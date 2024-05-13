package a2_2101140046;

public class PCReport {
    private static final int MAX_LINE_WIDTH = 99;

    private static int maxLength(String[] strings) {
        int count = 0;
        int index = 0;
        while (index < strings.length) {
            count = Math.max(count, strings[index].length());
            index++;
        }
        return count;
    }

    private static String[] getAttributes(PC[] objs, String NameOfValue) {
        String[] output = new String[objs.length];
        if (NameOfValue.equalsIgnoreCase("model")) {
            for (int i = 0; i < objs.length; i++) {
                output[i] = objs[i].getModel().toLowerCase();
            }
        } else if (NameOfValue.equalsIgnoreCase("manufacturer")) {
            for (int i = 0; i < objs.length; i++) {
                output[i] = objs[i].getManufacturer().toLowerCase();
            }
        }

        return output;

    }

    public String displayReport(PC[] objs) {
        StringBuilder report = new StringBuilder();

        // Create a horizontal line to wrap around the report
        StringBuilder horizontalLineBuilder = new StringBuilder();
        for (int i = 0; i < MAX_LINE_WIDTH; i++) {
            horizontalLineBuilder.append("-");
        }
        horizontalLineBuilder.append("\n");
        String horizontalLine = horizontalLineBuilder.toString();

        // Calculate padding for the report title
        int titlePadding = (MAX_LINE_WIDTH - "PCPROG REPORT".length()) / 2;

        // Add report title
        report.append(horizontalLine);
        report.append(String.format("%" + titlePadding + "sPCPROG REPORT%" + titlePadding + "s\n", "", "")).append("\n");
        report.append(horizontalLine);

        // Calculate the maximum width for each column
        int modelLength = Math.min(20, maxLength(getAttributes(objs, "model")));
        int manufacturerLength = Math.min(15, maxLength(getAttributes(objs, "manufacturer")));
        int yearLength = 6; // Fixed width for the year column

        // Loop through the objects to create rows
        int index = 1;
        for (PC p : objs) {
            String data = String.join(", ", p.getComps());

            // Truncate components if exceeding available space (considering paddings and separators)
            if (data.length() > MAX_LINE_WIDTH - modelLength - yearLength - manufacturerLength - 20) {
                // Fixed width for the first column = 3
                data = data.substring(0, MAX_LINE_WIDTH - modelLength - yearLength - manufacturerLength - 23) + ", ...";
            }

            // Format the row with proper column widths
            String dataRow = String.format("   %-3s %-" + modelLength + "s %-" + yearLength + "s %" + manufacturerLength + "s %s\n",
                    index++, p.getModel(), p.getYear(), p.getManufacturer(), "[" + data + "]");

            report.append(dataRow);
        }

        // Add the closing horizontal line
        report.append(horizontalLine);

        return report.toString();
    }
}
