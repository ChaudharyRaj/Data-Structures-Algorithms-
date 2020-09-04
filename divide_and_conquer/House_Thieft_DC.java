package divide_and_conquer;

public class House_Thieft_DC {
	public int maxMoney(int[] HouseNetWorth){
		return maxMoneyRecrsive(HouseNetWorth, 0);
	}
	private int maxMoneyRecrsive(int[] HouseNetWorth, int currentIndex) {
		if(currentIndex >= HouseNetWorth.length)
			return 0;
		int stealCurrentHouse = HouseNetWorth[currentIndex] + maxMoneyRecrsive(HouseNetWorth, currentIndex+2);
		int skipCurrntIndex  = maxMoneyRecrsive(HouseNetWorth, currentIndex+1);
		return Math.max(stealCurrentHouse, skipCurrntIndex);
	}
	public static void main(String[] args) {
		House_Thieft_DC ht = new House_Thieft_DC();
		int[] HouseNetWorth = {6, 7, 1, 30, 8, 2, 4};
		System.out.println(ht.maxMoney(HouseNetWorth));
		HouseNetWorth = new int[] {20, 5, 1, 13, 6, 11, 40};
		System.out.println(ht.maxMoney(HouseNetWorth));

	}

}
