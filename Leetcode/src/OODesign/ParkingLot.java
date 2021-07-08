package OODesign;

import java.util.PriorityQueue;

public class ParkingLot {
	
	int maxFloors;
	int spotsPerFloor;
	PriorityQueue<ParkingSpot> pq = new PriorityQueue<>((a,b) -> {
		if(a.floor == b.floor) {
			return a.getSpot() - b.getSpot();
		}else {
			return a.floor - b.floor;
		}
	});
	
	public ParkingLot(int maxFloors, int spotsPerFloor) {
		this.maxFloors = maxFloors;
		this.spotsPerFloor = spotsPerFloor;
		for(int i=0;i<maxFloors;i++) {
			for(int j=0;j<spotsPerFloor;j++) {
				ParkingSpot ps = new ParkingSpot(i,j);
				pq.add(ps);
			}
		}
	}
	
	public ParkingSpot park() {
		if(pq.size()<=0)throw new IllegalArgumentException("Parking lot full");
		return pq.poll();
	}
	
	public void unpark(int floor, int spot) {
		pq.add(new ParkingSpot(floor, spot));
	}
	
	class ParkingSpot{
		private int floor;
		private int spot;
		
		public ParkingSpot(int floor, int spot) {
			super();
			this.floor = floor;
			this.spot = spot;
		}
		public int getFloor() {
			return floor;
		}
		public void setFloor(int floor) {
			this.floor = floor;
		}
		public int getSpot() {
			return spot;
		}
		public void setSpot(int spot) {
			this.spot = spot;
		}
	}

	public static void main(String[] args) {
		ParkingLot pl = new ParkingLot(5,10);
		ParkingSpot ps1 = pl.park();
		System.out.println(ps1.getFloor()+"  "+ps1.getSpot());
		ParkingSpot ps2 = pl.park();
		System.out.println(ps2.getFloor()+"  "+ps2.getSpot());
		ParkingSpot ps = pl.park();
		System.out.println(ps.getFloor()+ "  "+ps.getSpot());
		System.out.println(pl.pq.peek().getFloor()+ "  "+pl.pq.peek().getSpot());
		pl.unpark(ps.getFloor(), ps.getSpot());
		System.out.println(ps.getFloor()+ "  "+ps.getSpot());
	}

}
