package test.Cases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import test.common.Locators;
import test.helper.Functions;

public class Videos{
	Functions function = new Functions();
	
	/**
	 * Test all of the possible given URL combinations are having the "group" tags of "video" record are correct [1]
	 * <p>Date Created: 2016-02-19</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-01</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testGroupTagIsCorrect() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/?group=Adult";
		String a = "program_asset_id=3106";
		String b = "size=60";
		String c = "sort_order=desc";
		String d = "sort_by=created_on";
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "video";
   		String tag = "group";
   		String expected = "Adult";
   		String condition = "equal";

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsCompareToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected, condition, false); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
		}
	
	/** 
	 * Test all of the possible given URL combinations are having the "program_asset_id" tags of "video" record are correct [2]
	 * <p>Date Created: 2016-02-19</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: video-02</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testProgramAssetIdTagIsCorrect() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/?program_asset_id=2790";		
		String a = "group=Adult";
		String b = "size=40";
		String c = "sort_order=desc";
		String d = "sort_by=born_date";		
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "video";
   		String tag = "program_asset_id";
   		String expected = "2790";
   		String condition = "equal";

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsCompareToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected, condition, false); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}

	/**
	 * Test all of the possible given URL combinations having maximum or less "video" records returned [3]
	 * <p>Date Created: 2016-02-19</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-03</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testVideoRecordsMaxNumber() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/?size=5";
		String a = "group=Adult";
		String b = "program_asset_id=2790";
		String c = "sort_order=asc";
		String d = "sort_by=born_date";
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d));
   		String record = "video";
   		int max = 5;

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsMaxNumber(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, max); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}

	/**
	 * Test all of the possible given URL combinations are having the "title" tags of "video" record are correct [4]
	 * <p>Date Created: 2016-02-19</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-04</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testTitleTagIsCorrect() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/?title=American Conservatism at the Crossroads";
		String a = "group=Adult";
		String b = "program_asset_id=2790";
		String c = "size=20";
		String d = "sort_order=asc";
		String e = "sort_by=born_date";
		
		String[] URL = Locators.url(root, Locators.combination(a, b, c, d, e));
		
		//// UNIT TEST
		// String[] URL = Locators.url(root, Locators.combination(b, c));
		
   		String record = "video";
   		String tag = "title";
   		String expected = "American Conservatism at the Crossroads";
   		String condition = "equal";

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsCompareToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected, condition, false); }
		catch (Exception exception) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}

	/**
	 * Test all of the possible given URL combinations having all the "created_on" tags of "video" record in ascending order [5]
	 * <p>Date Created: 2016-02-19</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-05</p>
	 * @throws IOException
	 */	
	@SuppressWarnings("static-access")
	@Test
	public void testCreateOnTagOrderIsAscending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/?sort_order=asc&sort_by=created_on";
		String a = "group=Adult";
		String b = "program_asset_id=1778";
		String c = "size=20";	
		String[] URL = Locators.url(root, Locators.combination(a, b, c));
   		String record = "video";
   		String tag = "created_on";

		for (int i = 0; i < URL.length; i++) {
		try { 
			 function.assertCpadTagsDateAsc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);
			 function.assertCpadTagsRecords (new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);	
		} catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}
	
	/**
	 * Test all of the possible given URL combinations having all the "created_on" tags of "video" record in descending order [6]
	 * <p>Date Created: 2016-02-10</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V1</p>
	 * <p>Modified Version: V2</p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-06</p>
	 * @throws IOException
	 */	
	@SuppressWarnings("static-access")
	@Test
	public void testCreateOnTagOrderIsDescending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/?sort_order=desc&sort_by=created_on";
		String a = "group=Adult";
		String b = "program_asset_id=1778";
		String c = "size=20";	
		String[] URL = Locators.url(root, Locators.combination(a, b, c));
   		String record = "video";
   		String tag = "created_on";

		for (int i = 0; i < URL.length; i++) {
		try { 
			 function.assertCpadTagsDateDesc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);
			 function.assertCpadTagsRecords (new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);	
		} catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}

	/**
	 * Test all of the possible given URL combinations having all the "updated_on" tags of "video" record in ascending order [7]
	 * <p>Date Created: 2016-02-19</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-07</p>
	 * @throws IOException
	 */	
	@SuppressWarnings("static-access")
	@Test
	public void testUpdatedOnTagOrderIsAscending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/?sort_order=asc&sort_by=updated_on";
		String a = "group=Adult";
		String b = "program_asset_id=2790";
		String c = "size=50";	
		String[] URL = Locators.url(root, Locators.combination(a, b, c));
   		String record = "video";
   		String tag = "updated_on";

		for (int i = 0; i < URL.length; i++) {
		try { 
			 function.assertCpadTagsDateAsc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);
			 function.assertCpadTagsRecords (new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);	
		} catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}

	/**
	 * Test all of the possible given URL combinations having all the "updated_on" tags of "video" record in descending order [8]
	 * <p>Date Created: 2016-02-19</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-08</p>
	 * @throws IOException
	 */	
	@SuppressWarnings("static-access")
	@Test
	public void testUpdatedOnTagOrderIsDescending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/?sort_order=desc&sort_by=updated_on";
		String a = "group=Adult";
		String b = "program_asset_id=2790";
		String c = "size=50";
		String[] URL = Locators.url(root, Locators.combination(a, b, c));
   		String record = "video";
   		String tag = "updated_on";

		for (int i = 0; i < URL.length; i++) {
		try { 
			 function.assertCpadTagsDateDesc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);
			 function.assertCpadTagsRecords (new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);	
		} catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}

	/**
	 * Test all of the possible given URL combinations having all the "born_date" tags of "video" record in descending order [9]
	 * <p>Date Created: 2016-02-19</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-09</p>
	 * @throws IOException
	 */	
	@SuppressWarnings("static-access")
	@Test
	public void testBornDateTagOrderIsDescending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/?sort_order=desc&sort_by=born_date";
		String a = "group=Adult";
		String b = "program_asset_id=8620";
		String c = "size=40";
		String[] URL = Locators.url(root, Locators.combination(a, b, c));
   		String record = "video";
   		String tag = "born_date";

		for (int i = 0; i < URL.length; i++) {
		try { 
			 function.assertCpadTagsDateDesc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);
		     function.assertCpadTagsRecords (new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);		
		} catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
		        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
        		 );
	}

	/**
	 * Test all of the possible given URL combinations having all the "kill_date" tags of "video" record in ascending order [10]
	 * <p>Date Created: 2016-02-19</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-10</p>
	 * @throws IOException
	 */	
	@SuppressWarnings("static-access")
	@Test
	public void testKillDateTagOrderIsAscending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/?sort_order=asc&sort_by=kill_date";
		String a = "group=Adult";
		String b = "program_asset_id=8620";
		String c = "size=50";	
		String[] URL = Locators.url(root, Locators.combination(a, b, c));
   		String record = "video";
   		String tag = "kill_date";

		for (int i = 0; i < URL.length; i++) {
		try { 
			 function.assertCpadTagsDateAsc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);
			 function.assertCpadTagsRecords (new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);	
		} catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}

	/**
	 * Test all of the possible given URL combinations having all the "kill_date" tags of "video" record in descending order [11]
	 * <p>Date Created: 2016-02-19</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-11</p>
	 * @throws IOException
	 */	
	@SuppressWarnings("static-access")
	@Test
	public void testKillDateTagOrderIsDescending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/?sort_order=desc&sort_by=kill_date";
		String a = "group=Adult";
		String b = "program_asset_id=8620";
		String c = "size=40";
		String[] URL = Locators.url(root, Locators.combination(a, b, c));
   		String record = "video";
   		String tag = "kill_date";
		
		for (int i = 0; i < URL.length; i++) {
		try { 
			 function.assertCpadTagsDateDesc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);
			 function.assertCpadTagsRecords (new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);		
		} catch (Exception e) { /** e.printStackTrace(); */ }
		}

		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
		        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
        		 );
	}
	
	/**
	 * Test given URL is having the "video_asset_id" filter for "video" record is correct [12]
	 * <p>Date Created: 2016-02-18</p>
	 * <p>Date Modified: 2016-02-18</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-12</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testVideoAssetIdTagIsCorrect() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/video_asset_id=281405";
		String[] URL = { root };
   		String record = "video";
   		String tag = "video_asset_id";
   		String expected = "281405";
   		String condition = "equal";

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsCompareToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected, condition, false); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}

	/**
	 * Test given URL is having the "record_id" filter for "video" record is correct [13]
	 * <p>Date Created: 2016-02-18</p>
	 * <p>Date Modified: 2016-02-18</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-13</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testRecordIdTagIsCorrect() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/record_id=2349866";
		String[] URL = { root };
   		String record = "video";
   		String tag = "record_id";
   		String expected = "2349866";
   		String condition = "equal";

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsCompareToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected, condition, false); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}

	/**
	 * Test given URL is having the "is_captioned" filter for "video" record is correct [14]
	 * <p>Date Created: 2016-02-18</p>
	 * <p>Date Modified: 2016-02-18</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-14</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testIsCaptionedTagIsCorrect() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/is_captioned=1";
		String[] URL = { root };
   		String record = "video";
   		String tag = "is_captioned";
   		String expected = "1";
   		String condition = "equal";

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsCompareToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected, condition, false); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}

	/**
	 * Test given URL is having the "brightcove_ref_id" filter for "video" record is correct [15]
	 * <p>Date Created: 2016-02-18</p>
	 * <p>Date Modified: 2016-02-18</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-15</p>
	 * @throws IOException
	 */
	@SuppressWarnings("static-access")
	@Test
	public void testBrightcoveRefIdTagIsCorrect() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/brightcove_ref_id=4737449177001";
		String[] URL = { root };
   		String record = "video";
   		String tag = "brightcove_ref_id";
   		String expected = "4737449177001";
   		String condition = "equal";

		for (int i = 0; i < URL.length; i++) {
		try { function.assertCpadTagsCompareToExpected(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag, expected, condition, false); }
		catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}
	
	/**
	 * Test all of the possible given URL combinations having all the "born_date" tags of "video" record in ascending order [16]
	 * <p>Date Created: 2016-02-19</p>
	 * <p>Date Modified: 2016-02-19</p>
	 * <p>Original Version: V2</p>
	 * <p>Modified Version: </p>
	 * <p>Xpath: 1</p>
	 * <p>User Stories: videos-16</p>
	 * @throws IOException
	 */	
	@SuppressWarnings("static-access")
	@Test
	public void testBornDateTagOrderIsAscending() throws IOException {
		function.printXmlPath(new RuntimeException().getStackTrace()[0]);
	    
		String root = Locators.cpadServerURL + "videos/?sort_order=asc&sort_by=born_date";
		String a = "group=Adult";
		String b = "program_asset_id=8620";
		String c = "size=50";	
		String[] URL = Locators.url(root, Locators.combination(a, b, c));
   		String record = "video";
   		String tag = "born_date";

		for (int i = 0; i < URL.length; i++) {
		try { 
			 function.assertCpadTagsDateAsc(new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);
			 function.assertCpadTagsRecords (new RuntimeException().getStackTrace()[0], URL[i], i+1, URL.length, false, record, tag);	
		} catch (Exception e) { /** e.printStackTrace(); */ }
		}
		
		// SCREENSHOT-DISABLED ASSERTION:
		Assert.assertTrue(Boolean.valueOf(function.fileScanner("cpad.log")), 
				        function.getAssertTrue(new RuntimeException().getStackTrace()[0],
		        		 "TEST # " + function.fileScanner("test.num") + " - Unexpected Results found!"
		        	   , Boolean.valueOf(function.fileScanner("cpad.log")), false)
		        		 );
	}
	
   @BeforeMethod public static void startTime() throws IOException { new Functions().startTime(); } 
   @AfterMethod  public static void endTime() throws IOException { new Functions().endTime(); }
}