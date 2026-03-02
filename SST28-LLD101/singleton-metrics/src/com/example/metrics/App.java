package com.example.metrics;

public class App {

    public static void main(String[] args) throws Exception {

        MetricsLoader loader = new MetricsLoader();

        MetricsRegistry registry =
                loader.loadFromFile("metrics.properties");

        registry.increment("REQUESTS_TOTAL");
        registry.increment("REQUESTS_TOTAL");
        registry.increment("DB_ERRORS");

        System.out.println("All Metrics: " + registry.getAll());
    }
}