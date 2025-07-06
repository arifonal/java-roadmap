package gorev3;

import java.io.*;
import java.util.*;

public class EmployeeDB implements Closeable {

    private final RandomAccessFile raf;

    public EmployeeDB(String fileName) throws IOException {
        raf = new RandomAccessFile(fileName, "rw");
    }

    public void add(EmployeeRec e) throws IOException {
        raf.seek(raf.length());
        e.writeTo(raf);
    }

    public EmployeeRec get(int id) throws IOException {
        long pos = (long) (id - 1) * EmployeeRec.RECORD_BYTES;
        if (pos >= raf.length()) return null;
        raf.seek(pos);
        return EmployeeRec.readFrom(raf);
    }

    public void updateSalary(int id, double newSalary) throws IOException {
        long pos = (long) (id - 1) * EmployeeRec.RECORD_BYTES + 4 + 40;
        if (pos >= raf.length()) return;
        raf.seek(pos);
        raf.writeDouble(newSalary);
    }

    public List<EmployeeRec> list() throws IOException {
        List<EmployeeRec> list = new ArrayList<>();
        raf.seek(0);
        while (raf.getFilePointer() < raf.length())
            list.add(EmployeeRec.readFrom(raf));
        return list;
    }

    @Override public void close() throws IOException { raf.close(); }
}
