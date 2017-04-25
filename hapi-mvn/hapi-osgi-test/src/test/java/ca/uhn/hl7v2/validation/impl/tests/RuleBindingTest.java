/*
 * Created on 7-Jun-2005
 */
package ca.uhn.hl7v2.validation.impl.tests;

import static org.ops4j.pax.exam.CoreOptions.equinox;
import static org.ops4j.pax.exam.CoreOptions.felix;
import static org.ops4j.pax.exam.CoreOptions.frameworks;
import static org.ops4j.pax.exam.CoreOptions.knopflerfish;
import static org.ops4j.pax.exam.CoreOptions.mavenBundle;
import static org.ops4j.pax.exam.CoreOptions.options;
import static org.ops4j.pax.exam.CoreOptions.systemProperty;
import static org.ops4j.pax.exam.CoreOptions.wrappedBundle;
import static org.ops4j.pax.exam.container.def.PaxRunnerOptions.logProfile;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.ops4j.pax.exam.Inject;
import org.ops4j.pax.exam.Option;
import org.ops4j.pax.exam.junit.Configuration;
import org.ops4j.pax.exam.junit.JUnit4TestRunner;
import org.osgi.framework.BundleContext;

import ca.uhn.hl7v2.validation.Rule;
import ca.uhn.hl7v2.validation.impl.RuleBinding;
import ca.uhn.hl7v2.validation.impl.SizeRule;
import junit.framework.TestCase;

/**
 * Unit tests for RuleBinding.  
 * 
 * @author <a href="mailto:bryan.tripp@uhn.on.ca">Bryan Tripp</a>
 * @version $Revision: 1.2 $ updated on $Date: 2009-09-15 12:11:18 $ by $Author: jamesagnew $
 * @author Niranjan Sharma niranjan.sharma@med.ge.com This testcase has been
 *         extended for OSGI environment using Junit4 and PAX-Exam.
 */
@RunWith(JUnit4TestRunner.class)
public class RuleBindingTest extends TestCase {

 // you get that because you "installed" a log profile in configuration.
    public Log logger = LogFactory.getLog(RuleBindingTest.class);
    
    @Inject
    BundleContext bundleContext;
    
    @Configuration
    public static Option[] configure() {
	return options(frameworks(equinox(), felix(), knopflerfish())
		, logProfile()
		, systemProperty("org.ops4j.pax.logging.DefaultServiceLog.level").value("INFO")
		, mavenBundle().groupId("org.ops4j.pax.url").artifactId("pax-url-mvn").version("0.4.0")
		, wrappedBundle(mavenBundle().groupId("org.ops4j.base").artifactId("ops4j-base-util").version("0.5.3"))
		, mavenBundle().groupId("ca.uhn.hapi").artifactId("hapi-osgi-base").version("1.0-beta1")
//		, vmOption("-Xrunjdwp:transport=dt_socket,server=y,suspend=y,address=5006" )


	);
    }    
    
    
    RuleBinding myBinding1;
    RuleBinding myBinding2;
    Rule myRule;
    
    @Test
    public void BeforeTheTest() throws Exception {
        myRule = new SizeRule(10);
        myBinding1 = new RuleBinding("*", "*", myRule);
        myBinding2 = new RuleBinding("2.5", "ST", myRule);
    }


    @Test
    public void testGetActive() {
        assertEquals(true, myBinding1.getActive());
        myBinding1.setActive(false);
        assertEquals(false, myBinding1.getActive());        
    }

    @Test
    public void testGetVersion() {
        assertEquals("2.5", myBinding2.getVersion());
    }

    @Test
    public void testGetScope() {
        assertEquals("ST", myBinding2.getScope());
    }

    @Test
    public void testGetRule() {
        assertEquals(myRule, myBinding2.getRule());
    }

    @Test
    public void testAppliesToVersion() {
        assertEquals(true, myBinding1.appliesToVersion("2.1"));        
        assertEquals(true, myBinding1.appliesToVersion("2.5"));        
        assertEquals(false, myBinding2.appliesToVersion("2.1"));        
        assertEquals(true, myBinding2.appliesToVersion("2.5"));        
    }

    @Test
    public void testAppliesToScope() {
        assertEquals(true, myBinding1.appliesToScope("ST"));        
        assertEquals(true, myBinding1.appliesToScope("DT"));        
        assertEquals(true, myBinding2.appliesToScope("ST"));        
        assertEquals(false, myBinding2.appliesToScope("DT"));        
    }

}
