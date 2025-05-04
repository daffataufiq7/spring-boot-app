package pengeluarandappa.dapp.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pengeluaran {
    private double jumlah;
    private String keterangan;
    private final String waktu;

    public Pengeluaran(double jumlah, String keterangan) {package pengeluarandappa.dapp.model;

        import jakarta.persistence.*;
        import java.time.LocalDateTime;
        import java.time.format.DateTimeFormatter;
        
        @Entity
        public class Pengeluaran {
            @Id
            @GeneratedValue(strategy = GenerationType.IDENTITY)
            private Long id;
        
            private double jumlah;
            private String keterangan;
            private String waktu;
        
            public Pengeluaran() {
                // default constructor diperlukan oleh JPA
            }
        
            public Pengeluaran(double jumlah, String keterangan) {
                this.jumlah = jumlah;
                this.keterangan = keterangan;
                this.waktu = LocalDateTime
                                .now()
                                .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
            }
        
            public Long getId()         { return id; }
            public double getJumlah()   { return jumlah; }
            public String getKeterangan() { return keterangan; }
            public String getWaktu()    { return waktu; }
        
            public void setJumlah(double jumlah)           { this.jumlah = jumlah; }
            public void setKeterangan(String keterangan)   { this.keterangan = keterangan; }
            public void setWaktu(String waktu)             { this.waktu = waktu; }
        }
        
        this.jumlah     = jumlah;
        this.keterangan = keterangan;
        this.waktu      = LocalDateTime
                            .now()
                            .format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }

    public double getJumlah()      { return jumlah; }
    public String getKeterangan() { return keterangan; }
    public String getWaktu()      { return waktu; }
}
