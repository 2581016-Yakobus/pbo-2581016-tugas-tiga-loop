import java.util.Scanner;

public class TigaLoop {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Batas deret (n) : ");
        int n = input.nextInt();

        System.out.println("\n===== SATU DERET, TIGA LOOP =====");

        // Versi 1: Loop for
        System.out.print("for      : ");
        for (int i = 1; i <= n; i++) {
            System.out.print(i + " ");
        }
        System.out.println();

        // Versi 2: Loop while
        System.out.print("while    : ");
        int j = 1;
        while (j <= n) {
            System.out.print(j + " ");
            j++;
        }
        System.out.println();

        // Versi 3: Loop do-while
        System.out.print("do-while : ");
        int k = 1;
        do {
            System.out.print(k + " ");
            k++;
        } while (k <= n);
        System.out.println();

        System.out.println();

        // Pembuktian off-by-one
        int kurang = 0;
        for (int i = 1; i < n; i++) {
            kurang++;
        }

        int kurangSama = 0;
        for (int i = 1; i <= n; i++) {
            kurangSama++;
        }

        System.out.println("i < n berputar : " + kurang + " kali");
        System.out.println("i <= n berputar : " + kurangSama + " kali");

        // Menyaring deret 1-10
        System.out.print("Disaring : ");
        int countPrintln = 0;
        for (int i = 1; i <= 10; i++) {
            if (i % 2 == 0) {
                continue;
            }
            if (i > 7) {
                break;
            }
            System.out.print(i + " ");
            countPrintln++;
        }
        System.out.println();
        System.out.println("Sampai println : " + countPrintln + " kali");

        input.close();
    }
}

/*
================================================================================
HASIL KELUARAN (OUTPUT) DUA KALI JALAN
================================================================================

Jalankan pertama, n = 5:

Batas deret (n) : 5

===== SATU DERET, TIGA LOOP =====
for      : 1 2 3 4 5
while    : 1 2 3 4 5
do-while : 1 2 3 4 5

i < n berputar : 4 kali
i <= n berputar : 5 kali
Disaring : 1 3 5 7
Sampai println : 4 kali


Jalankan kedua, n = 0:

Batas deret (n) : 0

===== SATU DERET, TIGA LOOP =====
for      :
while    :
do-while : 1

i < n berputar : 0 kali
i <= n berputar : 0 kali
Disaring : 1 3 5 7
Sampai println : 4 kali


================================================================================
ANALISIS DAN PENJELASAN
================================================================================

1. Mengapa dua baris pertama (for dan while) kosong pada n = 0, sedangkan do-while mencetak 1?
   - Loop `for` dan `while` memeriksa syarat kondisi di awal (sebelum menjalankan badan loop). Karena i = 1 dan n = 0, syarat (1 <= 0) bernilai false sehingga badan loop tidak dieksekusi sama sekali.
   - Loop `do-while` mencetak nilai terlebih dahulu baru memeriksa kondisi di akhir. Oleh karena itu, angka 1 sempat dicetak sebelum kondisi (k <= 0) diperiksa.
   - Kesimpulan: do-while mengecek kondisinya sesudah badan loop dijalankan, jadi badannya pasti jalan minimal sekali.

2. Mengapa loop penyaringan tidak berhenti pada i = 8 padahal sudah lebih besar dari 7?
   - Pengecekan `continue` (i % 2 == 0) diletakkan sebelum pengecekan `break` (i > 7).
   - Ketika i = 8, angka 8 adalah genap, sehingga `continue` langsung dieksekusi untuk melompati sisa kode di bawahnya (termasuk pemeriksaan break).
   - Loop baru berhenti saat i = 9 karena 9 adalah ganjil (melewati continue) dan memenuhi kondisi `break` (9 > 7).
*/