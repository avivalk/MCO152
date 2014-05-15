package kerstein.flickr;

import javax.swing.Icon;
import javax.swing.JLabel;

import org.junit.Test;
import org.mockito.Mockito;

public class DownloadImageThreadTest {

	@Test
	public void testCallLoadImages() {
		JLabel label = Mockito.mock(JLabel.class);
		DownloadImageThread thread = new DownloadImageThread(label,
				"https://farm3.staticflickr.com/2902/14179574494_91cfe3247a_m.jpg");

		thread.run();

		Mockito.verify(label, Mockito.times(1))
				.setIcon(Mockito.any(Icon.class));
	}

}
