package kerstein.clock;

public class AnimationThread extends Thread {

	private Clock clock;

	public AnimationThread(Clock clock) {
		this.clock = clock;
	}

	@Override
	public void run() {
		while (true) {
			clock.repaint();
			try {
				this.sleep(1000);
			} catch (InterruptedException e) {
			}
		}
	}
}
