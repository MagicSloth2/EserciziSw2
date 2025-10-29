package org.example.serie2.presentation;

import org.example.serie2.model.CustomerReport;
import org.example.serie2.model.RentalReportItem;

public class ReportFormatter {
    public static String toText(CustomerReport report) {
        StringBuilder sb = new StringBuilder();
        sb.append("Rental report for customer ").append(report.getCustomerName()).append("\n");

        for (RentalReportItem item : report.getItems()) {
            sb.append("\t")
                    .append(item.getRental().getSki().getName())
                    .append("\t")
                    .append(item.getCost())
                    .append("\n");
        }

        sb.append("Due amount: Fr. ").append(report.getTotalCost()).append("\n");
        sb.append("You earned ").append(report.getTotalPoints()).append(" bonus points\n");

        return sb.toString();
    }

    public static String toHtml(CustomerReport report) {
        StringBuilder sb = new StringBuilder();
        sb.append("<html><body>\n");
        sb.append("<h2>Rental report for customer ").append(report.getCustomerName()).append("</h2>\n");
        sb.append("<table border='1' cellpadding='5'>\n");
        sb.append("<tr><th>Ski Name</th><th>Cost</th></tr>\n");

        for (RentalReportItem item : report.getItems()) {
            sb.append("<tr>")
                    .append("<td>").append(item.getRental().getSki().getName()).append("</td>")
                    .append("<td>").append(item.getCost()).append("</td>")
                    .append("</tr>\n");
        }

        sb.append("</table>\n");
        sb.append("<p>Due amount: Fr. ").append(report.getTotalCost()).append("</p>\n");
        sb.append("<p>You earned ").append(report.getTotalPoints()).append(" bonus points</p>\n");
        sb.append("</body></html>");

        return sb.toString();
    }
}
