package com.example.reports;

/**
 * AFTER REFACTOR:
 * - Viewer now depends on the Report abstraction
 * - It can work with either RealReport or ReportProxy
 */
public class ReportViewer {

    public void open(Report report, User user) {
        report.display(user);
    }
}