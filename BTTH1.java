import java.util.ArrayList;
import java.util.Scanner;

abstract class Person {
    protected String name;
    protected int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract void displayInfo();
}

abstract class Candidate extends Person {
    private double DiemToan, DiemLy, DiemHoa;

    public Candidate(double DiemToan, double DiemLy, double DiemHoa, String name, int age) {
        super(name, age);
        this.DiemToan = DiemToan;
        this.DiemLy = DiemLy;
        this.DiemHoa = DiemHoa;
    }

    public double getDiemToan() {
        return DiemToan;
    }

    public void setDiemToan(double DiemToan) {
        this.DiemToan = DiemToan;
    }

    public double getDiemLy() {
        return DiemLy;
    }

    public void setDiemLy(double DiemLy) {
        this.DiemLy = DiemLy;
    }

    public double getDiemHoa() {
        return DiemHoa;
    }

    public void setDiemHoa(double DiemHoa) {
        this.DiemHoa = DiemHoa;
    }

    @Override
    public void displayInfo() {
        System.out.println("Ten: " + name + ", Tuoi: " + age
                + ", Diem Toan: " + getDiemToan()
                + ", Diem Ly: " + getDiemLy()
                + ", Diem Hoa: " + getDiemHoa());
    }

    public abstract double TongDiem();
}

class CandidateTest {

    private ArrayList<Candidate> candidates = new ArrayList<Candidate>();

    public void inputCandidates() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap so luong thi sinh: ");
        int numCandidates = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < numCandidates; i++) {
            System.out.print("Nhap ten thi sinh " + (i + 1) + ": ");
            String name = scanner.nextLine();
            System.out.print("Nhap tuoi cua thi sinh " + (i + 1) + ": ");
            int age = scanner.nextInt();
            System.out.print("Nhap diem Toan cua thi sinh " + (i + 1) + ": ");
            double diemToan = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Nhap diem Ly cua thi sinh " + (i + 1) + ": ");
            double diemLy = scanner.nextDouble();
            scanner.nextLine();
            System.out.print("Nhap diem hoa cua thi sinh " + (i + 1) + ": ");
            double diemHoa = scanner.nextDouble();
            scanner.nextLine();

            Candidate candidate = new Candidate(diemToan, diemLy, diemHoa, name, age){
                @Override
                public double TongDiem(){
                    return diemToan + diemHoa + diemLy;
                }

            };

            candidates.add(candidate);
        }
    }

    public void bubbleSort() {
        int n = candidates.size();
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < n; i++) {
                if (candidates.get(i - 1).TongDiem() < candidates.get(i).TongDiem()) {
                    Candidate temp = candidates.get(i - 1);
                    candidates.set(i - 1, candidates.get(i));
                    candidates.set(i, temp);
                    swapped = true;
                }
            }
        } while (swapped);
    }

    public void printAcceptedCandidates() {
        ArrayList<Candidate> acceptedCandidates = new ArrayList<Candidate>();

        for (Candidate candidate : candidates) {
            if (candidate.TongDiem() >= 18) {
                acceptedCandidates.add(candidate);
            }
        }

        bubbleSort();

        System.out.println("Danh sach thi sinh trung tuyen:");
        for (Candidate candidate : acceptedCandidates) {
            candidate.displayInfo();
        }

    }

    public void findCandidateScore(String candidateName) {
        for (Candidate candidate : candidates) {
            if (candidate.getName().equalsIgnoreCase(candidateName)) {
                System.out.println("Diem cua thi sinh " + candidateName + " la: " + candidate.TongDiem());
                return;
            }
        }
        System.out.println("Khong tim thay thi sinh co ten '" + candidateName + "'");
    }
}

public class BTTH1 {

    public static void main(String[] args) {
        CandidateTest test = new CandidateTest();
        test.inputCandidates();
        test.printAcceptedCandidates();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhap ten thi sinh de tra diem: ");
        String candidateName = scanner.nextLine();
        test.findCandidateScore(candidateName);
    }
}
