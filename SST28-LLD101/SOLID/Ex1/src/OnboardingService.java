import java.util.*;

public class OnboardingService {
    private final StudentRepository db;
    private final StudentParser parser;
    private final StudentValidator validator;
    private final RegistrationPrint printer;

    public OnboardingService(StudentRepository db) {
    this.db = db;
    this.parser = new StudentParser();
    this.validator = new StudentValidator();
    this.printer = new RegistrationPrint();
}

    // Intentionally violates SRP: parses + validates + creates ID + saves + prints.
    public void registerFromRawInput(String raw) {

    // 1. Print input
    printer.printInput(raw);

    // 2. Parse input
    Map<String,String> kv = parser.parse(raw);

    String name = kv.getOrDefault("name", "");
    String email = kv.getOrDefault("email", "");
    String phone = kv.getOrDefault("phone", "");
    String program = kv.getOrDefault("program", "");

    // 3. Validate
    List<String> errors = validator.validate(name, email, phone, program);

    if (!errors.isEmpty()) {
        printer.printErrors(errors);
        return;
    }

    // 4. Generate ID
    String id = IdUtil.nextStudentId(db.count());

    // 5. Create record
    StudentRecord rec = new StudentRecord(id, name, email, phone, program);

    // 6. Save
    db.save(rec);

    // 7. Print success
    printer.printSuccess(id, db.count(), rec);
}
}
