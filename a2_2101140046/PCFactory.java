package a2_2101140046;


import utils.NotPossibleException;

public class PCFactory {
    private static PCFactory instance;

    private PCFactory() {
    }

    public static PCFactory getInstance() {
        if (instance == null) {
            instance = new PCFactory();
        }
        return instance;
    }

    public PC createPC(String model, int year, String manufacturer, Set<String> comps) throws NotPossibleException {
        if (model == null || manufacturer == null || comps == null) {
            throw new IllegalArgumentException("Model, manufacturer, and components cannot be null");
        }

        if (year < 1984) {
            throw new IllegalArgumentException("Year must be greater than or equal to 1984");
        }

        try {
            return new PC(model, year, manufacturer, comps);
        } catch (NotPossibleException e) {
            // Handle exception accordingly
            e.printStackTrace();
            throw e;
        }
    }
}