package kelompok;

public class Member {
    String nama;
    String jenismember;
    String akses;
    int biaya;

    public Member(String nama, String jenismember, String akses, int biaya) {
        this.nama = nama;
        this.jenismember = jenismember;
        this.akses = akses;
        this.biaya = biaya;
    }

    Member() {}

    public String getNama() {
        return nama;
    }

    public String getJenismember() {
        return jenismember;
    }

    public String getAkses() {
        return akses;
    }

    public int getBiaya() {
        return biaya;
    }
}
