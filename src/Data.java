public class Data {
    private String value; 
    private int key;

    /**
     * Creates new Data instance
     * @param v A value
     * @param k a key for that value, since this is direct address, there is no hash function to convert value into the key
     */
    public Data(String v, int k) {
        value = v;
        key = k;
    }

    public String getValue() {return value;}
    public void setValue(String v) {value=v;}

    public int getKey() {return key;}
    public void setKey(int k) {key = k;}

    public String toString() {
        return "Data with key " + key + " and value " + value;
    }

    
}
