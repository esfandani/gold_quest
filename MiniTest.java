

import java.util.LinkedList;
import java.util.Queue;

public class MiniTest {
	public static void main(String[] args) {
		jadi_gold_quest();
	}
	public static void jadi_gold_quest(){
		Queue<Integer> six_month_q = new LinkedList<Integer>();
		six_month_q.add(1);
	//  int total_population =3000;
		int total_population =70000000;
		int income_pop = 0;//number of new people coming to the gold quest each month
		int pop_inv = 1;//total population involved for the gold quest. summation of all income_pop variable so far!
		int tnis =  1;//total number currently in the system.
		int outcome_pop = 0;//number of people going out of the gold quest system. Number of people who are in the system at least 6 months. They should go out of the system after it!
		int total_happy_pop = 0;//total number of happy people. summation of all outcome_pop variable so far. 
		int iteration = 1;//number of month
		int rate = 2;// rate of growth for each person.
		while(pop_inv < total_population){
			iteration++;
			if(iteration > 6){
				outcome_pop = six_month_q.poll();
			}
			
			income_pop = (tnis-outcome_pop)*rate;
			tnis = (tnis-outcome_pop)*(rate+1);
			int temp =  pop_inv + income_pop;
			if(temp > total_population){
				double remaining = (total_population - pop_inv);
				outcome_pop = (int) (((double)outcome_pop/tnis)*remaining);
				break;
			}
			pop_inv= temp;
			total_happy_pop+=outcome_pop;
			six_month_q.add(income_pop);
			System.out.println("new people in the system at this month:"+income_pop);
			System.out.println("people currently in ths system:"+tnis);
			System.out.println("<-------------------------------------------->");
		}
		total_happy_pop+=outcome_pop;
		System.out.println("happy people:"+total_happy_pop);
		System.out.println("month:"+(iteration-1));
	}

}

