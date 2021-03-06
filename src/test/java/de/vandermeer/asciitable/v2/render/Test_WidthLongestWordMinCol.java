/* Copyright 2014 Sven van der Meer <vdmeer.sven@mykolab.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package de.vandermeer.asciitable.v2.render;

import static org.junit.Assert.assertEquals;

import org.apache.commons.lang3.ArrayUtils;
import org.junit.Test;

import de.vandermeer.asciitable.v2.V2_AsciiTable;

/**
 * Tests for {@link WidthLongestWordMinCol}.
 *
 * @author     Sven van der Meer &lt;vdmeer.sven@mykolab.com&gt;
 * @version    v0.2.5 build 160301 (01-Mar-16) for Java 1.7
 */
public class Test_WidthLongestWordMinCol {

	@Test
	public void test_CodeForDoc(){
		V2_AsciiTable at;
		int[] cols;
		V2_Width width;


		at = new V2_AsciiTable();
		at.addRow("first", "information");
		at.addRow("second", "info");
		width = new WidthLongestWordMinCol(11);
		cols = width.getColumnWidths(at);
		assertEquals(2, cols.length);
		assertEquals(11, cols[0]);		// longest word: second (6) but min col is 11
		assertEquals(13, cols[1]);		// longest word: information (11) plus padding
		System.out.println(ArrayUtils.toString(cols));


		at = new V2_AsciiTable();
		at.addRow("first", "information");
		at.addRow("second", "info");
		width = new WidthLongestWordMinCol(new int[]{-1,50});
		cols = width.getColumnWidths(at);
		assertEquals(2, cols.length);
		assertEquals(8, cols[0]);		// longest word: second (6) plus padding no minimum given
		assertEquals(50, cols[1]);		// longest word: information (11) plus padding but min col is 50
		System.out.println(ArrayUtils.toString(cols));
	}
}
