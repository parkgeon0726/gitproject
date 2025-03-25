package gitproject;
//SHA-256 해시 알고리즘을 구현합니다.
//SHA-256 알고리즘을 구현하여 데이터를 안전하게 해싱합니다.
//256비트(32바이트)의 고정된 길이의 해시 값을 생성하는 단방향 암호화 알고리즘입니다. 이 알고리즘은 입력 데이터를 처리하여 고유한 해시 값을 반환하며, 주로 데이터 무결성 검증과 보안 목적으로 사용됩니다.

import java.security.MessageDigest;

public class Utils {

    /**
     * SHA-256 해시 값을 계산하는 메소드
     * @param input 해싱할 문자열
     * @return 16진수 문자열로 표현된 해시 값
     */
    public static String applySHA256(String input) {
        try {
            // MessageDigest 인스턴스를 SHA-256 알고리즘으로 초기화
            MessageDigest digest = MessageDigest.getInstance("SHA-256");

            // 입력 데이터를 바이트 배열로 변환 후 해시 계산
            byte[] hashBytes = digest.digest(input.getBytes("UTF-8"));

            // 바이트 배열을 16진수 문자열로 변환
            StringBuilder hexString = new StringBuilder();
            for (byte b : hashBytes) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0'); // 한 자리일 경우 앞에 '0' 추가
                hexString.append(hex);
            }

            return hexString.toString();
        } catch (Exception e) {
            throw new RuntimeException("SHA-256 해싱 중 오류 발생", e);
        }
    }

    // 테스트용 메인 메소드
    public static void main(String[] args) {
        String data = "Hello, Blockchain!";
        String hash = applySHA256(data);
        System.out.println("입력 데이터: " + data);
        System.out.println("SHA-256 해시 값: " + hash);
    }
}

