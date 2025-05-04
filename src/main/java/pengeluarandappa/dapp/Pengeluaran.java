import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pengeluaran {
    private double jumlah;
    private String keterangan;
    private final String waktu;  // Ubah menjadi final

    public Pengeluaran(double jumlah, String keterangan) {
        this.jumlah = jumlah;
        this.keterangan = keterangan;
        this.waktu = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public double getJumlah() {
        return jumlah;
    }

    public String getKeterangan() {
        return keterangan;
    }

    public String getWaktu() {
        return waktu;
    }
}
