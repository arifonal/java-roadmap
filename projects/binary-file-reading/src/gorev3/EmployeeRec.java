package gorev3;

/** sabit uzunluklu kayıt (4 + 40 + 8 = 52 byte) */
public class EmployeeRec {
    public int    id;
    public String name;    // max 20 karakter
    public double salary;

    public EmployeeRec(int id, String name, double salary) {
        this.id     = id;
        this.name   = name;
        this.salary = salary;
    }

    /* Kayıt sabitleri */
    static final int NAME_CHARS   = 20;
    static final int RECORD_BYTES = 4 + (NAME_CHARS * 2) + 8;

    public void writeTo(java.io.RandomAccessFile raf) throws java.io.IOException {
        raf.writeInt(id);

        String padded = String.format("%-" + NAME_CHARS + "s", name);
        for (int i = 0; i < NAME_CHARS; i++)
            raf.writeChar(padded.charAt(i));

        raf.writeDouble(salary);
    }

    public static EmployeeRec readFrom(java.io.RandomAccessFile raf)
            throws java.io.IOException {
        int id = raf.readInt();

        StringBuilder sb = new StringBuilder(NAME_CHARS);
        for (int i = 0; i < NAME_CHARS; i++)
            sb.append(raf.readChar());
        String nm = sb.toString().trim();

        double sal = raf.readDouble();
        return new EmployeeRec(id, nm, sal);
    }
}
