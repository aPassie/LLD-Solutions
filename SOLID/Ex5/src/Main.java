public class Main {
    public static void main(String[] args) {
        System.out.println("=== Export Demo ===");

        ExportRequest req = new ExportRequest("Weekly Report", SampleData.longBody());
        Exporter pdf = new PdfExporter();
        Exporter csv = new CsvExporter();
        Exporter json = new JsonExporter();

        // no need for try-catch anymore since all exporters follow the same contract
        System.out.println("PDF: " + export(pdf, req));
        System.out.println("CSV: " + export(csv, req));
        System.out.println("JSON: " + export(json, req));
    }

    private static String export(Exporter e, ExportRequest r) {
        ExportResult out = e.export(r);
        return "OK bytes=" + out.bytes.length;
    }
}
