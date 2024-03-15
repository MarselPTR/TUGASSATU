import java.util.*;

class User {
    String nama;
    String nim;
    String fakultas;
    String prodi;

    User(String nama, String nim, String fakultas, String prodi) {
        this.nama = nama;
        this.nim = nim;
        this.fakultas = fakultas;
        this.prodi = prodi;
    }
}

class Buku {
    String id_buku;
    String judul;
    String author;
    String category;
    int stockbuku;

    Buku(String id_buku, String judul, String author, String category, int stockbuku) {
        this.id_buku = id_buku;
        this.judul = judul;
        this.author = author;
        this.category = category;
        this.stockbuku = stockbuku;
    }
}

class Student {
    void displayBooks(ArrayList<Buku> bookList) {
        System.out.println("===== Daftar Buku =====");
        for (Buku buku : bookList) {
            System.out.println("ID Buku    : " + buku.id_buku);
            System.out.println("Judul Buku : " + buku.judul);
            System.out.println("Author     : " + buku.author);
            System.out.println("Category   : " + buku.category);
            System.out.println("Stok Buku  : " + buku.stockbuku);
            System.out.println("---------------------------------");
        }
    }
}

class Admin {
    Scanner input = new Scanner(System.in);

    void addStudent(ArrayList<User> userStudent) {
        Scanner input = new Scanner(System.in);
        System.out.print("Nama     : ");
        String nama = input.nextLine();
        String nim;
        do {
            System.out.print("NIM      : ");
            nim = input.next();
            if (nim.length() != 15)
                System.out.println("NIM harus 15 digit !!!");
        } while (nim.length() != 15);
        System.out.print("Fakultas : ");
        String fakultas = input.next();
        System.out.print("Prodi    : ");
        String prodi = input.next();

        userStudent.add(new User(nama, nim, fakultas, prodi));
        System.out.println("Mahasiswa berhasil ditambahkan.");
    }

    void displayStudent(ArrayList<User> userStudent) {
        System.out.println("===== Daftar Mahasiswa =====");
        for (User mahasiswa : userStudent) {
            System.out.println("Nama     : " + mahasiswa.nama);
            System.out.println("NIM      : " + mahasiswa.nim);
            System.out.println("Fakultas : " + mahasiswa.fakultas);
            System.out.println("Prodi    : " + mahasiswa.prodi);
            System.out.println("---------------------------------");
        }
    }
}

public class Main {
    static Scanner input = new Scanner(System.in);
    static ArrayList<User> userStudent = new ArrayList<>();
    static ArrayList<Buku> bookList = new ArrayList<>();

    public static void main(String[] args) {

        bookList.add(new Buku("388c-e681-9152", "Belajar Bahasa C", "Adi", "Pelajaran", 10));
        bookList.add(new Buku("ed90-be30-5cdb", "Naga dari Timyr", "Slamet", "Story", 20));
        bookList.add(new Buku("d95e-0c4a-9523", "Belajar Kalkulus", "Rama", "Pelajaran", 30));

        Main menu = new Main();
        menu.Menu();
    }

    void Menu() {
        int pilihan;
        do {
            System.out.println("====== Library System ======");
            System.out.println("1. Login Sebagai Mahasiswa");
            System.out.println("2. Login Sebagai Admin");
            System.out.println("3. Exit");
            System.out.print("Pilih Opsi (1-3): ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    inputNim();
                    break;
                case 2:
                    loginAdmin();
                    break;
                case 3:
                    exit();
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid!\nPilih Nomor (1-3) !");
            }
        } while (pilihan != 3);
    }

    private void inputNim() {
        System.out.print("Masukan NIM : ");
        String nim = input.next();
        if (nim.length() != 15) {
            System.out.println("Pengguna Ditemukan!");
        } else {
            System.out.println("Berhasil Login Sebagai Mahasiswa! ");
            Student student = new Student();
            student.displayBooks(bookList);
        }
    }

    private void loginAdmin() {
        System.out.print("Masukan Username (admin) : ");
        String username = input.next();
        input.nextLine();
        System.out.print("Masukan Password (admin) : ");
        String pw = input.next();

        if (username.equals("admin") && pw.equals("admin")) {
            menuAdmin();
        } else {
            System.out.println("Admin tidak ditemukan!");
        }
    }

    private void menuAdmin() {
        Admin admin = new Admin();
        int pilihan;
        do {
            System.out.println("===== Dashboard Admin =====");
            System.out.println("1. Tambah Mahasiswa");
            System.out.println("2. Tampilkan Daftar Mahasiswa");
            System.out.println("3. Logout");
            System.out.print("Pilih Opsi (1-3): ");
            pilihan = input.nextInt();

            switch (pilihan) {
                case 1:
                    admin.addStudent(userStudent);
                    break;
                case 2:
                    admin.displayStudent(userStudent);
                    break;
                case 3:
                    System.out.println("System has been loged out..!");
                    break;
                default:
                    System.out.println("Pilihan Tidak Valid!\nPilih Nomor (1-3) !");
            }
        } while (pilihan != 3);
    }

    private void exit() {
        System.out.println("Terima Kasih!");
        System.exit(0);
    }
}
