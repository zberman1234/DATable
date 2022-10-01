public class HashTable {
    Data[] table;

    /**
     * Default Table constructor, initializes Table with a size of 100
     */
    public HashTable() {
        table = new Data[100];
    }

    /**
     * Creates a table with a specified size
     * @param size the size to create the table with
     */
    public HashTable(int size) {
        table = new Data[size];
    }

    public Data[] getTable() {return table;}

    /**
     * Inserts a specified value into the Table with a specified key
     * @param k the key pointer to the value
     * @param v the value pointed to by the key
     */
    public void insert(int k, String v) {
        table[k] = new Data(v, k);
    }

    /**
     * Inserts an instance of the Data class into the Table
     * @param d the Datum to be inserted
     */
    public void insert(Data d) {
        table[d.getKey()] = d;
    }

    /**
     * Locates the Datum in the Table with a specified key 
     * @param k the key of the Data to locate
     * @return the data with key "k"
     */
    public Data search(int k) {
        return table[k];
    }

    /**
     * Deletes the Datum at the specified key from the Table
     * @param k the key value of the Data to be deleted
     */
    public void delete(int k) {
        table[k] = null;
    }


}
