import java.util.logging.*;

public class Main {

    static int pass=0;
    static int fail=0;

    private static Logger LOGGER = Logger.getLogger(Main.class.getName());
    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");

        testDefConstructor();
        testParamConstructor();
        testInsert();
        testJustEnoughInsert();
        testTooMuchInsert();
        testEmptySearch();
        testSearch();
        testDelete();
        testDeleteOutOfBounds();

        System.out.println("Passed: " + pass + " Failed: " + fail);


    }

    /**
     * Tests the table default constructor, by confirming that the table size was set to the expected default size of 100
     */
    public static void testDefConstructor() {
        HashTable ht = new HashTable();
        int size = ht.getTable().length;
        if(size == 100) pass++;
        else {
            LOGGER.log(Level.WARNING, "Failed testDefaultConstructor: expected size 100, got " + size);
        }
    }

    /**
     * Tests the parameterized constructor by confirming that the table size was set to the expected input size
     */
    public static void testParamConstructor() {
        int expected = 2000;
        HashTable ht = new HashTable(expected);
        int actual = ht.getTable().length;
        if(actual == expected) pass++;
        else {
            LOGGER.log(Level.WARNING, "Failed testParameterizedConstructor: expected size " + expected + ", got " + actual);
        }
    }

    /**
     * Tests HashTable insert function by inserting a Datum with a key, 
     * and then confirming that the value at the keyth index of the table matches the Datum's input value
     */
    public static void testInsert() {
        HashTable ht = new HashTable();
        int k = 4;
        String val = "Spaceship";
        ht.insert(k, val);
        String actual = ht.getTable()[k].getValue();
        if(actual.equals(val)) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING, "Failed testInsert: Expected value " + val + " at table index " + k + ", got " + actual);
        }
    }

    /**
     * Tests HashTable insert function by inserting a Datum with a key, 
     * and then confirming that the value at the keyth index of the table matches the Datum's input value
     */
    public static void testDataInsert() {
        HashTable ht = new HashTable();
        int k = 4;
        String val = "Spaceship";
        Data d = new Data(val, k);
        ht.insert(d);
        Data actual = ht.getTable()[k];
        if(actual.equals(d)) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING, "Failed testDataInsert: Expected Data " + d + " at table index " + d.getKey() + ", got " + actual);
        }
    }

    

    /**
     * Tests HashTable insert function by inserting just enough Data to not overflow the array
     * catches indexOutOfBounds error if array is overflowed
     */
    public static void testJustEnoughInsert() {
        HashTable ht = new HashTable();
        try {
            for(int i = 0; i < ht.getTable().length - 1; i++) {
                ht.insert(i, i+"value");
            }
        }
        catch(ArrayIndexOutOfBoundsException exception) {
            fail++;
            LOGGER.log(Level.WARNING, "Failed testJustEnoughInsert: Out of Bounds error thrown when it should not have");
        }
        pass++;
    }

    /**
     * Tests HashTable insert function by inserting too much Data, and confirming that an IndexOutOfBounds error was thrown
     */
    public static void testTooMuchInsert() {
        HashTable ht = new HashTable();
        try {
            for(int i = 0; i < ht.getTable().length + 1; i++) {
                ht.insert(i, i+"value");
            }
        } 
        catch(ArrayIndexOutOfBoundsException exception) {
            pass++;
            return;
        }
        fail++;
        LOGGER.log(Level.WARNING, "Failed testTooMuchInsert: Out of Bounds error expected but not thrown");
        
    }

    /**
     * Tests HashTable search function by searching for a Datum at an unassigned key index, 
     * confirms that there is no Datum at this index
     */
    public static void testEmptySearch() {
        HashTable ht = new HashTable();
        int k = 5;
        if(ht.search(k) == null) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING, "Failed testEmptySearch: Expected empty Table and null value at keyth index, but null was not detected");
        }
    }

    /**
     * Tests HashTable search by adding two Data, and then searching for the first one added, 
     * and confirming that the returned parameters match the inserted params
     */
    public static void testSearch() {
        HashTable ht = new HashTable();
        Data d = new Data("Spaceship", 5);
        Data d1 = new Data("Mars", 6);
        ht.insert(d);
        ht.insert(d1);
        if(ht.search(5).getKey() == 5 && ht.search(5).getValue().equals("Spaceship")) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING, "Failed testSearch: Returned Data parameters not equal to expected parameters");
        }
    }

    /**
     * Tests HashTable delete function by inserting two Data, deleting the first, and confirming that the value at the first's key is null
     */
    public static void testDelete() {
        HashTable ht = new HashTable();
        Data d = new Data("Spaceship", 5);
        Data d1 = new Data("Mars", 6);
        ht.insert(d);
        ht.insert(d1);
        ht.delete(5);
        if(ht.search(5) == null) pass++;
        else {
            fail++;
            LOGGER.log(Level.WARNING, "Failed testDelete: Expected nulled Data was not found to be nulled");
        }
    }

    /**
     * Tests HashTable delete function by attempting to delete a Data at a key value out of the bounds of the Table, 
     * confirms that an IndexOutOfBounds error is thrown
     */
    public static void testDeleteOutOfBounds() {
        HashTable ht = new HashTable();
        Data d = new Data("Spaceship", 5);
        Data d1 = new Data("Mars", 6);
        ht.insert(d);
        ht.insert(d1);
        try{
            ht.delete(1000);
        } catch(IndexOutOfBoundsException e) {
            pass++;
            return;
        }
        fail++;
        LOGGER.log(Level.WARNING, "Failed testDeleteOutOfBounds: Attempted deletion at OutOfBounds index did not throw expected exception");
        
    }

}
