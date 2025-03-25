package gitproject;
//블록체인에서 트랜잭션은 사용자가 데이터를 전송하거나 자산을 교환하는 기록입니다. 
//이를 구현하기 위해 트랜잭션 클래스를 추가하고, 각 트랜잭션의 유효성을 검증합니다.

public class Transaction {
    public String sender; // 송신자
    public String receiver; // 수신자
    public double amount; // 송금 금액

    public Transaction(String sender, String receiver, double amount) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
    }

    // 트랜잭션 유효성 확인 (예: 잔액 확인)
    public boolean isValid(double senderBalance) {
        return senderBalance >= amount; // 송신자가 충분한 잔액을 가지고 있는지 확인
    }
}