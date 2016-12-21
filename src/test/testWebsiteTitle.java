/**
 * 
 */
package test;

import static org.junit.Assert.*;

import org.junit.Test;

import util.WebsiteTitle;

/**
 * @author sam
 *
 */
public class testWebsiteTitle {

	/**
	 * Test method for {@link util.WebsiteTitle#getTitle()}.
	 */
	@Test
	public void testGetTitle() {
		assertEquals("Lauren's Lovely Landscapes", new WebsiteTitle().getTitle());
	}

	
	/**
	 * Test method for {@link util.WebsiteTitle#setTitle(java.lang.String)}.
	 */
	@Test
	public void testSetTitle() {
		String newTitle = "This is not Lauren's Lovely Landscapes";
		WebsiteTitle title = new WebsiteTitle();
		title.setTitle(newTitle);
		assertEquals(newTitle, title.getTitle());
		
		
		
	}

}
