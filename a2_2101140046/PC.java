package a2_2101140046;
import utils.*;

/**
 * @overview PC class represents the properties of attributes with essential state and behaviour spaces
 *           plus toString; equals function
 * @attributes   model String        - the model of the PC
 *               year int            - the year the PC was manufactured
 *               manufacturer String - the manufacturer of the PC
 *               comps Set<String>   - the set of properties (0 => many) included in the PC
 * @object A PC consist of c=<m,y,mr,c>
 *         where model(m), year(y), manufacturer(mr), comps(c).
 * @abstract_domainconstraints
 *                      Mutable(model) = true /\ Optional(model) = false /\ length(max length) = 20
 *                      Mutable(year) = false /\ Optional(year)=false /\ min(year) = 1984
 *                      Mutable(manufacturer) = false /\ Optional(manufacturer) = false /\ length(max length) = 15
 *                      Mutable(comps) = true /\ Optional(comps)=false
 * @requires model, manufacturer are not null
 * @effects Set up the ready attributes for PCFactory class
 *
 */
public class PC {
    @DomainConstraint(type = "String",mutable = true,optional = false,length = 20)
    private String model;
    @DomainConstraint(type = "Integer",mutable = false,optional = false,min = 1984)
    private int year;
    @DomainConstraint(type = "String",mutable = false,optional = false,length = 15)
    private String manufacturer;
    @DomainConstraint(type = "String",mutable = true,optional = false)
    private Set<String> comps;
    /**
     * @effects
     * if model, year, manufacturer, comps are validSpecifying the Behaviour Space
     * initialise this as <model, year, manufacturer, comps>
     * else
     * throws NotPossibleException
     */

    public PC(@AttrRef("model")String model, @AttrRef("year")int year, @AttrRef("manufacturer")String manufacturer, @AttrRef("comps")Set<String> comps)
            throws NotPossibleException {
        if (validateModel(model) && validateYear(year) && validateManuF(manufacturer)) {
            this.model = model;
            this.year = year;
            this.manufacturer = manufacturer;
        } else {
            throw new NotPossibleException("The length of input value is invalid !");
        }
        this.comps = comps;
    }
    /**
     * @effects  return model
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("model")
    public String getModel() {
        return model;
    }
    /**
     * @effects
     * @modifies this
     * return model
     */
    @DOpt(type=OptType.Mutator)
    @AttrRef("model")
    public boolean setModel(String model) {
        this.model = model;
        return true;
    }
    /**
     * @effects  check the constraints
     */
    private boolean validateModel(String model) {
        return model != null && model.length() <= 20;
    }

    /**
     * @effects  return year
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("year")
    public int getYear() {
        return year;
    }
    /**
     * @effects  check the constraints
     */
    private boolean validateYear(int year) {
        return year >= 1984;
    }
    /**
     * @effects  return manufacturer
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("manufacturer")
    public String getManufacturer() {
        return manufacturer;
    }
    /**
     * @effects  check the constraints
     */
    private boolean validateManuF(String manufacturer) {
        return manufacturer != null && manufacturer.length() <= 15;
    }
    /**
     * @effects  return comps
     */
    @DOpt(type = OptType.Observer)
    @AttrRef("comps")
    public Set<String> getComps() {
        return comps;
    }
    /**
     * @effects
     * @modifies this
     * return comps
     */
    @DOpt(type = OptType.Mutator)
    @AttrRef("comps")
    public boolean setComps(Set<String> comps) {
        // Ensure that the 'comps' attribute is mutable
        this.comps.clear(); // Clear the existing set
        this.comps.addAll(comps); // Add all elements from the new set
        return true;
    }

    @Override
    public String toString(){
        return "PC<" + model + "," + year + "," + manufacturer  + "," + comps.toString() + ">";
    }

    /**
     * @effects Takes an Object argument and returns boolean
     * Also means the two objects are behaviorally equivalent if they have the same year, model, manufacturer.
     * @param obt the compared object
     * @return true if the argument is equal to the current object, false if otherwise
     */
    public boolean equals(Object obt){
        if (this == obt)
            return true;
        if (obt == null || getClass() != obt.getClass())
            return false;
        PC p = (PC) obt;
        return year == p.year &&
                model.equals(p.model) &&
                manufacturer.equals(p.manufacturer) &&
                comps.equals(p.comps);
    }
}

