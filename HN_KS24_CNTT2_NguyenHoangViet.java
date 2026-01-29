package SS5;

import java.util.Scanner;
import java.util.regex.Pattern;

public class HN_KS24_CNTT2_NguyenHoangViet {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] mssvList = new String[100];
        int choice;
        String regex = "^B\\d{7}$";
        int count = 0;
        do {
            System.out.println("\n====== QUẢN LÝ MSSV ======");
            System.out.println("1. Hiển thị danh sách MSSV");
            System.out.println("2. Thêm MSSV mới");
            System.out.println("3. Cập nhật MSSV theo vị trí");
            System.out.println("4. Xóa MSSV");
            System.out.println("5. Tìm kiếm MSSV");
            System.out.println("0. Thoát");
            System.out.println("==========================");
            System.out.print("Chọn chức năng: ");

            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                choice = -1;
            }
            switch(choice){
                case 1:
                    if(count == 0) {
                        System.out.println("Danh sách MSSV rỗng");
                    } else {
                        System.out.println("\n--- DANH SÁCH MSSV ---");
                        for (int i = 0; i<count;i++) {
                            System.out.println((i + 1) + ". " + mssvList[i]);
                        }
                    }
                    break;
                case 2:
                    if (count>=100){
                        System.out.println("Mảng đã đầy");
                        break;
                    }

                    String newMSSV;
                    while(true){
                        System.out.print("Nhập MSSV: ");
                        newMSSV=scanner.nextLine();
                        if (Pattern.matches(regex,newMSSV)) {
                            break;
                        }
                        System.out.println("MSSV không hợp lệ");
                    }
                    mssvList[count] = newMSSV;
                    count++;
                    System.out.println("Thêm MSSV thành công");
                    break;
                case 3:
                    if (count == 0) {
                        System.out.println("Danh sách rỗng");
                        break;
                    }

                    System.out.print("Nhập vị trí cần sửa: ");
                    int index;
                    try {
                        index=Integer.parseInt(scanner.nextLine()) - 1;
                    }catch(Exception e) {
                        System.out.println("Vị trí không hợp lệ");
                        break;
                    }
                    if (index < 0 || index >= count) {
                        System.out.println("Vị trí không hợp lệ");
                        break;
                    }
                    String updateMSSV;
                    while (true){
                        System.out.print("Nhập MSSV mới: ");
                        updateMSSV=scanner.nextLine();
                        if (Pattern.matches(regex, updateMSSV)) {
                            break;
                        }
                        System.out.println("MSSV không hợp lệ");
                    }

                    mssvList[index] = updateMSSV;
                    System.out.println("Cập nhật thành công");
                    break;
                case 4:
                    if (count==0) {
                        System.out.println("Danh sách rỗng");
                        break;
                    }
                    System.out.print("Nhập MSSV cần xóa: ");
                    String deleteMSSV=scanner.nextLine();
                    int deleteIndex=-1;
                    for (int i = 0; i < count;i++) {
                        if (mssvList[i].equalsIgnoreCase(deleteMSSV)) {
                            deleteIndex = i;
                            break;
                        }
                    }
                    if (deleteIndex == -1) {
                        System.out.println("Không tìm thấy MSSV!");
                        break;
                    }
                    for (int i = deleteIndex; i < count - 1;i++) {
                        mssvList[i] = mssvList[i + 1];
                    }
                    mssvList[count-1] = null;
                    count--;
                    System.out.println("Xóa MSSV thành công");
                    break;
                case 5:
                    if (count==0){
                        System.out.println("Danh sách rỗng");
                        break;
                    }
                    System.out.print("Nhập chuỗi cần tìm: ");
                    String keyword = scanner.nextLine().toLowerCase();
                    boolean found = false;
                    System.out.println("\nKết quả:");
                    for (int i = 0; i < count; i++) {
                        if (mssvList[i].toLowerCase().contains(keyword)) {
                            System.out.println((i + 1) + ". " + mssvList[i]);
                            found = true;
                        }
                    }
                    if (!found) {
                        System.out.println("Không thấy MSSV phù hợp");
                    }
                    break;
                case 0:
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ");
            }
        } while (choice != 0);
        scanner.close();
    }
}