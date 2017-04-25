/**
 *
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL
 * Software distributed under the License is distributed on an "AS IS" basis,
 * WITHOUT WARRANTY OF ANY KIND, either express or implied. See the License for the
 * specific language governing rights and limitations under the License.
 *
 * The Initial Developer of the Original Code is University Health Network. Copyright (C)
 * 2001.  All Rights Reserved.
 *
 * Alternatively, the contents of this file may be used under the terms of the
 * GNU General Public License (the  "GPL"), in which case the provisions of the GPL are
 * applicable instead of those above.  If you wish to allow use of your version of this
 * file only under the terms of the GPL and not to allow others to use your version
 * of this file under the MPL, indicate your decision by deleting  the provisions above
 * and replace  them with the notice and other provisions required by the GPL License.
 * If you do not delete the provisions above, a recipient may use your version of
 * this file under either the MPL or the GPL.
 */
package ca.uhn.hunit.event.expect;

import ca.uhn.hunit.ex.ConfigurationException;
import ca.uhn.hunit.ex.TestFailureException;
import ca.uhn.hunit.ex.UnexpectedMessageException;
import ca.uhn.hunit.iface.TestMessage;
import ca.uhn.hunit.msg.AbstractMessage;
import ca.uhn.hunit.run.IExecutionContext;
import ca.uhn.hunit.test.TestImpl;
import ca.uhn.hunit.xsd.Event;
import ca.uhn.hunit.xsd.ExpectNoMessage;
import java.util.LinkedHashMap;

/**
 * TODO: add!
 *
 * @author <a href="mailto:james.agnew@uhn.on.ca">James Agnew</a>
 * @version $Revision: 1.2 $ updated on $Date: 2011-03-21 12:51:59 $ by $Author: jamesagnew $
 */
public class ExpectNoMessageImpl extends AbstractExpect {
    //~ Constructors ---------------------------------------------------------------------------------------------------

    /**
     * @param theBattery
     * @param theTest
     * @param theConfig
     * @throws ConfigurationException
     */
    public ExpectNoMessageImpl(TestImpl theTest, ExpectNoMessage theConfig)
                        throws ConfigurationException {
        super(theTest, theConfig);
    }

    //~ Methods --------------------------------------------------------------------------------------------------------

    /**
     * {@inheritDoc}
     */
    @Override
    public void execute(IExecutionContext theCtx) throws TestFailureException, ConfigurationException {
        TestMessage<?> message = getInterface().receiveMessage(getReceiveTimeout(), null);

        if (message != null) {
            throw new UnexpectedMessageException(getTest(), message, "Unexpected message received");
        }
    }

    public Event exportConfig(ExpectNoMessage theConfig) {
        super.exportConfig(theConfig);

        return theConfig;
    }

    @Override
    public ExpectNoMessage exportConfigToXml() {
        return (ExpectNoMessage) exportConfig(new ExpectNoMessage());
    }

    @Override
    public Object exportConfigToXmlAndEncapsulate() {
        return exportConfigToXml();
    }

    /**
     * {@inheritDoc }
     */
    @Override
    public LinkedHashMap<String, AbstractMessage<?>> getAllMessages() {
        LinkedHashMap<String, AbstractMessage<?>> retVal = new LinkedHashMap<String, AbstractMessage<?>>();
        return retVal;
    }
}
