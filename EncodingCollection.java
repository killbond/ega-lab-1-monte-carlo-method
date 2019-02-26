import java.util.ArrayList;

public class EncodingCollection {

    private ArrayList<Encoding> collection;

    private int length;

    public EncodingCollection(int length) {
        this.length = length;
        this.collection = new ArrayList<Encoding>();
        for (int i = 0; i < Math.pow(2, length); i++) {
            this.collection.add(new Encoding(i));
        }
    }

    public EncodingCollection(ArrayList<Encoding> collection, int length) {
        this.length = length;
        this.collection = collection;
    }

    public int getLength() {
        return this.collection.size();
    }

    public Encoding getMax() {
        Encoding result = this.collection.get(0);
        for (Encoding current : this.collection) {
            if (current.getAdaptability().square(this.length) > result.getAdaptability().square(this.length)) {
                result = current;
            }
        }
        return result;
    }

    public ArrayList<Encoding> asList() {
        return this.collection;
    }

    public String toString() {
        String result = "";
        for (Encoding current : this.collection) {
            result += current.toString(this.length) + " (" +
                current.getAdaptability().square(this.length) + "), ";
        }

        if (result.length() > 2) {
            result = result.substring(0, result.length() - 2);
        }

        return result;
    }

    public Encoding getRandom() {
        int position = (int)(Math.random() * this.getLength());
        return this.collection.get(position);
    }
}
