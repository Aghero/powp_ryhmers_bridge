package edu.kis.vh.nursery;

import edu.kis.vh.nursery.factory.ArrayFactory;
import edu.kis.vh.nursery.factory.DefaultRhymersFactory;
import edu.kis.vh.nursery.factory.ListFactory;
import edu.kis.vh.nursery.factory.Ryhmersfactory;

class RyhmersDemo {

	public static void main(String[] args) {
		Ryhmersfactory factory = new DefaultRhymersFactory();
		ArrayFactory arrayRyhmersFactory = new ArrayFactory();
		ListFactory listRyhmersFactory = new ListFactory();

		testRyhmers(factory);
		testRyhmers(arrayRyhmersFactory);
		testRyhmers(listRyhmersFactory);
		
	}

	private static void testRyhmers(Ryhmersfactory factory) {
				DefaultCountingOutRhymer[] ryhmers = { factory.getStandardRhymer(), factory.getFalseRhymer(),
								factory.getFIFORhymer(), factory.getHanoiRhymer()};
		for (int i = 1; i < 15; i++)
			for (int j = 0; j < 3; j++)
				ryhmers[j].countIn(i);

		java.util.Random rn = new java.util.Random();
		for (int i = 1; i < 15; i++)
			ryhmers[3].countIn(rn.nextInt(20));

		for (int i = 0; i < ryhmers.length; i++) {
			while (!ryhmers[i].callCheck())
				System.out.print(ryhmers[i].countOut() + "  ");
			System.out.println();
		}

		System.out.println("total rejected is "
				+ ((HanoiRhymer) ryhmers[3]).reportRejected());
	}

}