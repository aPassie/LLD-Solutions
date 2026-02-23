import java.nio.charset.StandardCharsets;

public class CsvExporter implements Exporter {
    @Override
    public ExportResult export(ExportRequest req) {
        // fixed: properly quote csv fields instead of destroying commas and newlines
        String body = req.body == null ? "" : req.body;
        String csv = "title,body\n" + csvQuote(req.title) + "," + csvQuote(body) + "\n";
        return new ExportResult("text/csv", csv.getBytes(StandardCharsets.UTF_8));
    }

    // wraps field in double quotes and escapes any double quotes inside
    private String csvQuote(String field) {
        if (field == null) return "\"\"";
        String escaped = field.replace("\"", "\"\"");
        return "\"" + escaped + "\"";
    }
}
