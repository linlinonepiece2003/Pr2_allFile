package a2_2101140046;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.Vector;

import utils.NotPossibleException;
/**
 * A program that captures data about PC objects and displays
 * a report about them on the console.
 */
public class PCProg {
    private static final Object YES = "Y";
    private Set<PC> objs;

    /**
     * Initialise this to have an empty set of PCs
     */
    public PCProg() {
        objs = new Set<>();
    }

    /**
     * If <tt>objs</tt> is not empty, displays a text-based tabular
     * report on <tt>objs</tt> to the standard console.
     * Displays nothing if <tt>objs</tt> is empty.
     *
     * @return this report if <tt>objs</tt> is not empty or <tt>null</tt> otherwise.
     */
    public String displayReport() {
        if (!objs.isEmpty()) {
            Vector<PC> pcs = objs.getElements();
            PCReport reportObj = new PCReport();
            return reportObj.displayReport(pcs.toArray(new PC[0]));
        } else {
            return null;
        }
    }

    /**
     * Saves report to a file <tt>pcs.txt</tt> in the program's working directory.
     */
    public void saveReport(String report) {
        String fileName = "pcs.txt";
        try (PrintWriter pw = new PrintWriter(fileName)) {
            pw.println(report);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public Set<PC> getObjects() {
        return objs;
    }

    public void createObjects() {
        boolean PC_create = true;
        Scanner sc = new Scanner(System.in);
        PCFactory pcFactory = PCFactory.getInstance(); // Create an instance of PCFactory

        while (PC_create) {
            System.out.println("Input enter model less than 20 characters: ");
            String pmodel = sc.nextLine();
            int pyear = 0;
            do {
                try {
                    System.out.println("Please enter year bigger than or equal 1984:");
                    pyear = Integer.parseInt(sc.nextLine());
                    if (pyear <= 1984) {
                        throw new NotPossibleException("Year must be greater than or equal to 1984.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Year must be an integer.");
                } catch (NotPossibleException e) {
                    System.out.println(e.getMessage());
                }
            } while (pyear <= 1984);

            System.out.println("Please enter manufacturer less than 15 characters: ");
            String pmanu = sc.nextLine();

            Set<String> pcomps = new Set<>();
            while (true) {
                System.out.println("Please enter components , then enter, then write 'stop' if you want to stop add: ");
                String comp = sc.nextLine();
                if (comp.equalsIgnoreCase("stop")) {
                    break;
                }
                pcomps.insert(comp);
            }

            try {
                // Create PC by PCFactory instance and add to objs set
                objs.insert(pcFactory.createPC(pmodel, pyear, pmanu, pcomps));
            } catch (NotPossibleException e) {
                System.out.println(e.getMessage());
            }

            System.out.println("Do you want to add more computer ? 'Y' or 'N'");
            String add = sc.nextLine();
            if (add.equalsIgnoreCase("n")) {
                PC_create = false;
            }

        }
    }


    /**
     * Initializes an instance of <tt>PCProg</tt>.
     * Create objects from data entered by the user.
     * Display a report on the objects.
     * Prompt user to save report to file. If user answers "Y", save report.
     * Otherwise, end program.
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PCProg prog = new PCProg();
        try {
            // create objects
            prog.createObjects();
            // display report
            String report = prog.displayReport();
            System.out.println(report);
            if (report != null) {
                // prompt user to save report
                System.out.println("Save report to file? [Y/N]");
                String toSave = sc.nextLine();
                if (toSave.equals("Y")) {
                    prog.saveReport(report);
                    System.out.println("report saved");
                }
            }
        } catch (NotPossibleException e) {
            System.err.printf("%s: %s%n", e, e.getMessage());
        }
        System.out.println("~END~");
    }
}


