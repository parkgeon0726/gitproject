package gitproject;
//블록체인을 관리하고 실행하는 메인 클래스입니다.
//블록체인을 생성하고 관리하며, 각 블록을 연결합니다.
//메인 메서드에서 실행됩니다.

import java.util.ArrayList;

public class Blockchain {
    public static ArrayList<Block> blockchain = new ArrayList<>(); // 블록체인 리스트
    public static int difficulty = 4; // 작업 증명 난이도 설정

    // 블록 채굴 메서드
    public static void mineBlock(Block block) {
        String target = new String(new char[difficulty]).replace('\0', '0'); // 목표 해시값 (난이도 기반)
        while (!block.hash.substring(0, difficulty).equals(target)) {
            block.nonce++; // nonce 값을 증가시켜 해시값 변경 시도
            block.hash = block.calculateHash();
        }
        System.out.println("블록 채굴 완료: " + block.hash);
    }

    // 블록체인 무결성 검증 메서드
    public static boolean isChainValid() {
        for (int i = 1; i < blockchain.size(); i++) {
            Block currentBlock = blockchain.get(i);
            Block previousBlock = blockchain.get(i - 1);

            // 현재 블록의 해시값 재계산 및 비교
            if (!currentBlock.hash.equals(currentBlock.calculateHash())) {
                System.out.println("현재 블록의 해시값이 일치하지 않습니다.");
                return false;
            }

            // 이전 블록의 해시값과 비교
            if (!currentBlock.previousHash.equals(previousBlock.hash)) {
                System.out.println("이전 블록의 해시값이 일치하지 않습니다.");
                return false;
            }
        }
        return true;
    }

    // 메인 메서드: 실행 예제
    public static void main(String[] args) {
        // 첫 번째 블록 (Genesis Block)
        Block genesisBlock = new Block("첫 번째 블록 데이터", "0");
        System.out.println("첫 번째 블록 채굴 중...");
        mineBlock(genesisBlock);
        blockchain.add(genesisBlock);

        // 두 번째 블록
        Block secondBlock = new Block("두 번째 블록 데이터", genesisBlock.hash);
        System.out.println("두 번째 블록 채굴 중...");
        mineBlock(secondBlock);
        blockchain.add(secondBlock);

        // 세 번째 블록
        Block thirdBlock = new Block("세 번째 블록 데이터", secondBlock.hash);
        System.out.println("세 번째 블록 채굴 중...");
        mineBlock(thirdBlock);
        blockchain.add(thirdBlock);

        // 블록체인 유효성 확인
        System.out.println("\n블록체인이 유효한가요? " + isChainValid());
    }
}

//확장 가능성 이 코드는 간단한 블록체인의 기본 구조를 보여줍니다. 이를 확장하여 다음과 같은 기능을 추가할 수 있습니다:
//트랜잭션 처리 및 검증
//작업 증명(Proof of Work)
//P2P 네트워크 통합
//이를 통해 더 복잡하고 실제 사용 가능한 블록체인 시스템으로 발전시킬 수 있습니다.