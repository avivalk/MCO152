package kerstein.flickr;

import org.junit.Test;
import org.mockito.Mockito;

public class DownloadFlickerFeedThreadTest {

	@Test
	public void testCallsLoadImages() {
		// because need frame for feed to test, have to create a MOCK one using
		// mockito jar-can call a method ona mock but will return null/false/0
		// but we just want to test that loadImages is called, not if it
		// executes correctly
		FlickerFeedFrame frame = Mockito.mock(FlickerFeedFrame.class);
		DownloadFlickerFeedThread thread = new DownloadFlickerFeedThread(frame);
		Mockito.verify(frame, Mockito.never()).loadImages(
				Mockito.any(FlickerFeed.class));// verifying that loadImages was
												// not called cuz if loadImages
												// is in constructor, it would
												// run and fail
		thread.run();// calling run instead of start because we want to execute
						// the code in the same thread that the test is
						// currently running in
						// calling thread.start() starts a new thread and we
						// dont want that
		Mockito.verify(frame, Mockito.times(1)).loadImages(
				Mockito.any(FlickerFeed.class));// verifying that loadImages was
												// called once
		// need Mockito.any cuz need a feed
	}
}
