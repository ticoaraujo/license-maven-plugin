/*
 * #%L
 * License Maven Plugin
 * %%
 * Copyright (C) 2008 - 2011 CodeLutin, Codehaus, Tony Chemit, Tony chemit
 * %%
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation, either version 3 of the
 * License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Lesser Public License for more details.
 *
 * You should have received a copy of the GNU General Lesser Public
 * License along with this program.  If not, see
 * <http://www.gnu.org/licenses/lgpl-3.0.html>.
 * #L%
 */

def assertExistsFile(file) {
    if (!file.exists() || file.isDirectory()) {
        println(file.getAbsolutePath() + " file is missing or a directory.")
        assert false
    }
    assert true
}

def assertContains(file, content, expected) {
    if (!content.contains(expected)) {
        println(expected + " was not found in file [" + file + "]\n :" + content)
        return false
    }
    return true
}

file = new File(basedir, 'target/generated-sources/license/THIRD-PARTY.txt');
assertExistsFile(file);

content = file.text;
assert assertContains(file, content, '(Custom defined license in PR-64) Jettison (org.codehaus.jettison:jettison:1.1 - no url defined)');

return true;
