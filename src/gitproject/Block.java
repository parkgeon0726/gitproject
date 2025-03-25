package gitproject;
//블록의 구조와 해시 계산을 담당합니다.
//각 블록의 데이터, 이전 해시값, 현재 해시값을 저장하며, 해시를 계산합니다.
//데이터를 보호하기 위해 SHA-256 알고리즘을 사용합니다.
public class Block {
    public String hash;
    public String previousHash;
    private String data; // 블록 데이터
    private long timeStamp; // 블록 생성 시간
    public int nonce; // 작업 증명에 사용되는 값

    // 생성자 정의
    public Block(String data, String previousHash) {
        this.data = data;
        this.previousHash = previousHash;
        this.timeStamp = System.currentTimeMillis();
        this.hash = calculateHash(); // 해시값 계산
    }

    // SHA-256 해시 계산 메서드
    public String calculateHash() {
        return Utils.applySHA256(previousHash + Long.toString(timeStamp) + Integer.toString(nonce) + data);
    }
}



