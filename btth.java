import java.util.*;
import java.util.regex.*;

public class btth {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n====== MENU THUẬT TOÁN ======");
            System.out.println("1. Two Sum (Tìm cặp số có tổng K)");
            System.out.println("2. Move Zeroes (Dồn số 0 về cuối)");
            System.out.println("3. Valid Palindrome (Chuỗi đối xứng)");
            System.out.println("4. Reverse Words (Đảo ngược từ)");
            System.out.println("5. Happy Number (Số hạnh phúc)");
            System.out.println("0. Thoát");
            System.out.print("Chọn chức năng: ");

            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (Exception e) {
                choice = -1;
            }
            switch (choice) {
                case 1: {
                    System.out.print("Nhập số phần tử: ");
                    int n = Integer.parseInt(sc.nextLine());
                    int[] arr = new int[n];

                    for (int i = 0; i < n; i++) {
                        System.out.print("arr[" + i + "] = ");
                        arr[i] = Integer.parseInt(sc.nextLine());
                    }
                    System.out.print("Nhập target: ");
                    int target = Integer.parseInt(sc.nextLine());

                    boolean found = false;
                    for (int i = 0; i < n; i++) {
                        for (int j = i + 1; j < n; j++) {
                            if (arr[i] + arr[j] == target) {
                                System.out.println("Tìm thấy: i = " + i + ", j = " + j);
                                found = true;
                                break;
                            }
                        }
                    }

                    if (!found) {
                        System.out.println("Không tìm thấy cặp số phù hợp!");
                    }
                    break;
                }


                case 2: {
                    System.out.print("Nhập số phần tử: ");
                    int n = Integer.parseInt(sc.nextLine());
                    int[] arr = new int[n];

                    for (int i = 0; i < n; i++) {
                        System.out.print("arr[" + i + "] = ");
                        arr[i] = Integer.parseInt(sc.nextLine());
                    }

                    int pos = 0;
                    for (int i = 0; i < n; i++) {
                        if (arr[i] != 0) {
                            int temp = arr[pos];
                            arr[pos] = arr[i];
                            arr[i] = temp;
                            pos++;
                        }
                    }

                    System.out.println("Mảng sau khi dồn 0:");
                    System.out.println(Arrays.toString(arr));
                    break;
                }


                case 3: {
                    System.out.print("Nhập chuỗi: ");
                    String input = sc.nextLine();

                    String cleaned = input.replaceAll("[^a-zA-Z]", "").toLowerCase();

                    int left = 0, right = cleaned.length() - 1;
                    boolean isPalindrome = true;

                    while (left < right) {
                        if (cleaned.charAt(left) != cleaned.charAt(right)) {
                            isPalindrome = false;
                            break;
                        }
                        left++;
                        right--;
                    }

                    System.out.println("Kết quả: " + isPalindrome);
                    break;
                }


                case 4: {
                    System.out.print("Nhập chuỗi: ");
                    String input = sc.nextLine();

                    String[] words = input.trim().split("\\s+");
                    StringBuilder sb = new StringBuilder();

                    for (int i = words.length - 1; i >= 0; i--) {
                        sb.append(words[i]).append(" ");
                    }

                    System.out.println("Chuỗi sau xử lý:");
                    System.out.println(sb.toString().trim());
                    break;
                }


                case 5: {
                    System.out.print("Nhập số n: ");
                    int n = Integer.parseInt(sc.nextLine());

                    Set<Integer> seen = new HashSet<>();

                    while (n != 1 && !seen.contains(n)) {
                        seen.add(n);
                        int sum = 0;

                        while (n > 0) {
                            int digit = n % 10;
                            sum += digit * digit;
                            n /= 10;
                        }
                        n = sum;
                    }

                    System.out.println(n == 1
                            ? "Đây là số hạnh phúc!"
                            : "Đây KHÔNG phải số hạnh phúc!");
                    break;
                }

                case 0:
                    System.out.println("Đã thoát chương trình!");
                    break;

                default:
                    System.out.println("Lựa chọn không hợp lệ!");
            }

        } while (choice != 0);

        sc.close();
    }
}
