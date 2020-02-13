package com.ziprange.model;

/**
 * A model represents start range and end range of a zip combo.
 */
public class ZipCodeRange implements Comparable<ZipCodeRange> {

    // Low bound of the zip code range
    private int start;

    // Up bound of the zip code range
    private int end;

    public ZipCodeRange(int start, int end) {
        this.start = start;
        this.end = end;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }

    @Override
    public int compareTo(ZipCodeRange o) {
        return Integer.compare(this.start, o.getStart());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ZipCodeRange that = (ZipCodeRange) o;

        if (start != that.start) return false;
        return end == that.end;
    }

    @Override
    public int hashCode() {
        int result = start;
        result = 31 * result + end;
        return result;
    }

    @Override
    public String toString() {
        return "[" + this.start + "," + this.end + "]";
    }
}
