import java.util.HashMap;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> map = new HashMap<>();

        // 각 의상 종류별로 개수를 저장
        for (String[] item : clothes) {
            String type = item[1];
            map.put(type, map.getOrDefault(type, 0) + 1);
        }

        int result = 1;

        // 조합 계산: 각 의상 종류마다 (입지 않는 경우 + 입는 경우)를 곱함
        for (int count : map.values()) {
            result *= (count + 1); // 입지 않는 경우를 포함하기 위해 +1
        }

        // 최소 하나는 입어야 하므로 아무것도 입지 않는 경우(=1)를 제외
        return result - 1;
    }
}
