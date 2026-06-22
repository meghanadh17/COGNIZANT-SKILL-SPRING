class Report {
    public void generateReport() {
        System.out.println("Generating report...");
    }
}

public class SRPExample {
    public static void main(String[] args) {
        Report report = new Report();
        report.generateReport();
    }
}