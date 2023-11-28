package pl.wla.webproject.repository.entities;


import java.io.Serializable;
import java.util.Objects;

public class InvoicePositionID implements Serializable {
    private int posInvNo;

    private int posNo;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoicePositionID that = (InvoicePositionID) o;
        return posInvNo == that.posInvNo && posNo == that.posNo;
    }

    @Override
    public int hashCode() {
        return Objects.hash(posInvNo, posNo);
    }
}
