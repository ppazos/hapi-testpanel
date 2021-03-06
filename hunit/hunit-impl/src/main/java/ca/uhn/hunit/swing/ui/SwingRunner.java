/**
 *
 * The contents of this file are subject to the Mozilla Public License Version 1.1
 * (the "License"); you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at http://www.mozilla.org/MPL/
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
/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/*
 * SwingRunner.java
 *
 * Created on 22-Jul-2009, 10:57:14 PM
 */
package ca.uhn.hunit.swing.ui;

import ca.uhn.hunit.event.AbstractEvent;
import ca.uhn.hunit.iface.AbstractInterface;

import ca.uhn.hunit.msg.AbstractMessage;
import ca.uhn.hunit.swing.controller.ctx.AbstractContextController;
import ca.uhn.hunit.swing.controller.SwingRunnerController;
import ca.uhn.hunit.swing.model.EventTreeNode;
import ca.uhn.hunit.swing.model.InterfaceTreeNode;
import ca.uhn.hunit.swing.model.InterfacesTreeRenderer;
import ca.uhn.hunit.swing.model.MessageTreeNode;
import ca.uhn.hunit.swing.model.MyTreeModel;
import ca.uhn.hunit.swing.model.TestBatteryTreeNode;
import ca.uhn.hunit.swing.model.TestTreeNode;
import ca.uhn.hunit.test.TestBatteryImpl;
import ca.uhn.hunit.test.TestImpl;
import java.awt.BorderLayout;
import java.util.Enumeration;
import javax.swing.JPanel;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.tree.TreeNode;
import javax.swing.tree.TreePath;

/**
 *
 * @author James
 */
public class SwingRunner extends javax.swing.JFrame {

    private static final long serialVersionUID = 1L;

    private TestBatteryImpl myBattery;
    private final SwingRunnerController myController;
    private MyTreeModel myTreeModel;

    /** Creates new form SwingRunner
     * @param theBatteryImpl */
    public SwingRunner(SwingRunnerController theController, TestBatteryImpl theBatteryImpl) {
        this.myController = theController;

        initComponents();
        setBattery(theBatteryImpl);

        myTestTree.setCellRenderer(new InterfacesTreeRenderer());

        ((BasicSplitPaneUI) myOuterSplitPane.getUI()).getDivider().setBorder(null);

    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        myAddPopupMenu = new javax.swing.JPopupMenu();
        myAddTestMenu = new javax.swing.JMenu();
        myAddTestEmptyMenuItem = new javax.swing.JMenuItem();
        myAddInterfaceMenu = new javax.swing.JMenu();
        myAddMllpHl7v2InterfaceMenu = new javax.swing.JMenuItem();
        myAddJmsInterfaceMenu = new javax.swing.JMenuItem();
        myAddJavaInterfaceMenuItem = new javax.swing.JMenuItem();
        jToolBar1 = new javax.swing.JToolBar();
        myFileNewButton = new javax.swing.JButton();
        myButtonOpen = new javax.swing.JButton();
        myButtonSave = new javax.swing.JButton();
        jSeparator2 = new javax.swing.JToolBar.Separator();
        myExecuteButton = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JToolBar.Separator();
        myOuterSplitPane = new javax.swing.JSplitPane();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        myTestTree = new javax.swing.JTree();
        jToolBar2 = new javax.swing.JToolBar();
        myAddButton = new javax.swing.JButton();
        myTestContextPanel = new javax.swing.JPanel();
        jMenuBar1 = new javax.swing.JMenuBar();
        myFileMenu = new javax.swing.JMenu();
        jMenu1 = new javax.swing.JMenu();
        myNewMenuItem = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();
        myOpenMenuItem = new javax.swing.JMenuItem();
        mySaveMenuItem = new javax.swing.JMenuItem();
        mySaveAsMenuItem = new javax.swing.JMenuItem();

        java.util.ResourceBundle bundle = java.util.ResourceBundle.getBundle("ca/uhn/hunit/l10n/UiStrings"); // NOI18N
        myAddTestMenu.setText(bundle.getString("batterylist.buttons.add.test")); // NOI18N

        myAddTestEmptyMenuItem.setText(bundle.getString("batterylist.buttons.add.test.empty")); // NOI18N
        myAddTestEmptyMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myAddTestEmptyMenuItemActionPerformed(evt);
            }
        });
        myAddTestMenu.add(myAddTestEmptyMenuItem);

        myAddPopupMenu.add(myAddTestMenu);

        myAddInterfaceMenu.setText(bundle.getString("batterylist.buttons.add.interface")); // NOI18N

        myAddMllpHl7v2InterfaceMenu.setText(bundle.getString("batterylist.buttons.add.interface.mllp.hl7v2")); // NOI18N
        myAddMllpHl7v2InterfaceMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myAddMllpHl7v2InterfaceMenuActionPerformed(evt);
            }
        });
        myAddInterfaceMenu.add(myAddMllpHl7v2InterfaceMenu);

        myAddJmsInterfaceMenu.setText(bundle.getString("batterylist.buttons.add.interface.jms")); // NOI18N
        myAddInterfaceMenu.add(myAddJmsInterfaceMenu);

        myAddJavaInterfaceMenuItem.setText(bundle.getString("batterylist.buttons.add.interface.java")); // NOI18N
        myAddJavaInterfaceMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myAddJavaInterfaceMenuItemActionPerformed(evt);
            }
        });
        myAddInterfaceMenu.add(myAddJavaInterfaceMenuItem);

        myAddPopupMenu.add(myAddInterfaceMenu);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("hUnit");

        jToolBar1.setRollover(true);

        myFileNewButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/uhn/hunit/ui/resources/images/filenew.png"))); // NOI18N
        myFileNewButton.setText(bundle.getString("toolbar.new")); // NOI18N
        myFileNewButton.setFocusable(false);
        myFileNewButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myFileNewButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        myFileNewButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myFileNewButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(myFileNewButton);

        myButtonOpen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/uhn/hunit/ui/resources/images/open.png"))); // NOI18N
        myButtonOpen.setText(bundle.getString("toolbar.open")); // NOI18N
        myButtonOpen.setFocusable(false);
        myButtonOpen.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myButtonOpen.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        myButtonOpen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButtonOpenActionPerformed(evt);
            }
        });
        jToolBar1.add(myButtonOpen);

        myButtonSave.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/uhn/hunit/ui/resources/images/save.png"))); // NOI18N
        myButtonSave.setText(bundle.getString("toolbar.save")); // NOI18N
        myButtonSave.setFocusable(false);
        myButtonSave.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myButtonSave.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        myButtonSave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myButtonSaveActionPerformed(evt);
            }
        });
        jToolBar1.add(myButtonSave);
        jToolBar1.add(jSeparator2);

        myExecuteButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/uhn/hunit/ui/resources/images/button_execute.png"))); // NOI18N
        myExecuteButton.setText(bundle.getString("toolbar.execute")); // NOI18N
        myExecuteButton.setFocusable(false);
        myExecuteButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        myExecuteButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        myExecuteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myExecuteButtonActionPerformed(evt);
            }
        });
        jToolBar1.add(myExecuteButton);
        jToolBar1.add(jSeparator1);

        myOuterSplitPane.setBorder(null);
        myOuterSplitPane.setDividerLocation(200);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(bundle.getString("runner.battery.panel"))); // NOI18N

        myTestTree.addTreeSelectionListener(new javax.swing.event.TreeSelectionListener() {
            public void valueChanged(javax.swing.event.TreeSelectionEvent evt) {
                myTestTreeValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(myTestTree);

        jToolBar2.setBorder(null);
        jToolBar2.setRollover(true);

        myAddButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/uhn/hunit/ui/resources/images/add.png"))); // NOI18N
        myAddButton.setText(bundle.getString("batterylist.buttons.add")); // NOI18N
        myAddButton.setFocusable(false);
        myAddButton.setHorizontalTextPosition(javax.swing.SwingConstants.LEFT);
        myAddButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        myAddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myAddButtonActionPerformed(evt);
            }
        });
        jToolBar2.add(myAddButton);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jToolBar2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 168, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jToolBar2, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addContainerGap())
        );

        myOuterSplitPane.setLeftComponent(jPanel1);

        myTestContextPanel.setLayout(new java.awt.BorderLayout());
        myOuterSplitPane.setRightComponent(myTestContextPanel);

        myFileMenu.setMnemonic('F');
        myFileMenu.setText("File");

        jMenu1.setText(bundle.getString("menu.file.new")); // NOI18N

        myNewMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/uhn/hunit/ui/resources/images/filenew.png"))); // NOI18N
        myNewMenuItem.setText(bundle.getString("menu.file.new.blank")); // NOI18N
        myNewMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fileNewClicked(evt);
            }
        });
        jMenu1.add(myNewMenuItem);

        jMenuItem1.setText(bundle.getString("menu.file.new.hl7_v2_in_and_out")); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newTemplateHl7InAndOut(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        myFileMenu.add(jMenu1);

        myOpenMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/uhn/hunit/ui/resources/images/open.png"))); // NOI18N
        myOpenMenuItem.setMnemonic('o');
        myOpenMenuItem.setText(bundle.getString("toolbar.open")); // NOI18N
        myOpenMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                myOpenMenuItemActionPerformed(evt);
            }
        });
        myFileMenu.add(myOpenMenuItem);

        mySaveMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_MASK));
        mySaveMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/uhn/hunit/ui/resources/images/save.png"))); // NOI18N
        mySaveMenuItem.setMnemonic('s');
        mySaveMenuItem.setText(bundle.getString("toolbar.save")); // NOI18N
        mySaveMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mySaveMenuItemActionPerformed(evt);
            }
        });
        myFileMenu.add(mySaveMenuItem);

        mySaveAsMenuItem.setIcon(new javax.swing.ImageIcon(getClass().getResource("/ca/uhn/hunit/ui/resources/images/save.png"))); // NOI18N
        mySaveAsMenuItem.setMnemonic('v');
        mySaveAsMenuItem.setText(bundle.getString("toolbar.saveas")); // NOI18N
        mySaveAsMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mySaveAsMenuItemActionPerformed(evt);
            }
        });
        myFileMenu.add(mySaveAsMenuItem);

        jMenuBar1.add(myFileMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jToolBar1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 758, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(myOuterSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 738, Short.MAX_VALUE)
                .addGap(10, 10, 10))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jToolBar1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(myOuterSplitPane, javax.swing.GroupLayout.DEFAULT_SIZE, 523, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void myTestTreeValueChanged(javax.swing.event.TreeSelectionEvent evt) {//GEN-FIRST:event_myTestTreeValueChanged
        Object selectedModelObject = evt.getPath().getLastPathComponent();

        if (selectedModelObject instanceof InterfaceTreeNode) {
            final AbstractInterface selectedInterface = ((InterfaceTreeNode) selectedModelObject).getInterface();
            myController.selectInterface(selectedInterface);
        } else if (selectedModelObject instanceof MessageTreeNode) {
            AbstractMessage<?> message = ((MessageTreeNode) selectedModelObject).getMessage();
            myController.selectMessage(message);
        } else if (selectedModelObject instanceof TestTreeNode) {
            TestImpl test = ((TestTreeNode) selectedModelObject).getTest();
            myController.selectTest(test);
        } else if (selectedModelObject instanceof TestBatteryTreeNode) {
            TestBatteryImpl battery = ((TestBatteryTreeNode) selectedModelObject).getBattery();
            myController.selectBattery(battery);
        } else if (selectedModelObject instanceof EventTreeNode) {
            EventTreeNode eventTreeNode = (EventTreeNode) selectedModelObject;
			AbstractEvent event = eventTreeNode.getEvent();
            myController.selectEvent(eventTreeNode.getTest(), event);
        } else {
            System.out.println(selectedModelObject);
        }

    }//GEN-LAST:event_myTestTreeValueChanged

    private void myExecuteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myExecuteButtonActionPerformed
        myController.execute();
    }//GEN-LAST:event_myExecuteButtonActionPerformed

    private void myAddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myAddButtonActionPerformed
        myAddPopupMenu.show(myAddButton, 0, myAddButton.getHeight());
    }//GEN-LAST:event_myAddButtonActionPerformed

    private void myAddMllpHl7v2InterfaceMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myAddMllpHl7v2InterfaceMenuActionPerformed
        myController.addInterfaceMllpHl7v2();
    }//GEN-LAST:event_myAddMllpHl7v2InterfaceMenuActionPerformed

    private void myButtonSaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButtonSaveActionPerformed
        myController.save();
    }//GEN-LAST:event_myButtonSaveActionPerformed

    private void mySaveAsMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mySaveAsMenuItemActionPerformed
        myController.saveAs();
    }//GEN-LAST:event_mySaveAsMenuItemActionPerformed

    private void myButtonOpenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myButtonOpenActionPerformed
        myController.open();
    }//GEN-LAST:event_myButtonOpenActionPerformed

    private void mySaveMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_mySaveMenuItemActionPerformed
        myController.save();
    }//GEN-LAST:event_mySaveMenuItemActionPerformed

    private void myOpenMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myOpenMenuItemActionPerformed
        myController.open();
    }//GEN-LAST:event_myOpenMenuItemActionPerformed

    private void myAddTestEmptyMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myAddTestEmptyMenuItemActionPerformed
        myController.addTestEmpty();
    }//GEN-LAST:event_myAddTestEmptyMenuItemActionPerformed

    private void fileNewClicked(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fileNewClicked
        myController.newFile();
    }//GEN-LAST:event_fileNewClicked

    private void myFileNewButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myFileNewButtonActionPerformed
        myController.newFile();
    }//GEN-LAST:event_myFileNewButtonActionPerformed

    private void newTemplateHl7InAndOut(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newTemplateHl7InAndOut
        myController.newTemplateHl7InAndOut();
    }//GEN-LAST:event_newTemplateHl7InAndOut

    private void myAddJavaInterfaceMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_myAddJavaInterfaceMenuItemActionPerformed
        myController.addInterfaceJavaCallable();
    }//GEN-LAST:event_myAddJavaInterfaceMenuItemActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar.Separator jSeparator1;
    private javax.swing.JToolBar.Separator jSeparator2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JToolBar jToolBar2;
    private javax.swing.JButton myAddButton;
    private javax.swing.JMenu myAddInterfaceMenu;
    private javax.swing.JMenuItem myAddJavaInterfaceMenuItem;
    private javax.swing.JMenuItem myAddJmsInterfaceMenu;
    private javax.swing.JMenuItem myAddMllpHl7v2InterfaceMenu;
    private javax.swing.JPopupMenu myAddPopupMenu;
    private javax.swing.JMenuItem myAddTestEmptyMenuItem;
    private javax.swing.JMenu myAddTestMenu;
    private javax.swing.JButton myButtonOpen;
    private javax.swing.JButton myButtonSave;
    private javax.swing.JButton myExecuteButton;
    private javax.swing.JMenu myFileMenu;
    private javax.swing.JButton myFileNewButton;
    private javax.swing.JMenuItem myNewMenuItem;
    private javax.swing.JMenuItem myOpenMenuItem;
    private javax.swing.JSplitPane myOuterSplitPane;
    private javax.swing.JMenuItem mySaveAsMenuItem;
    private javax.swing.JMenuItem mySaveMenuItem;
    private javax.swing.JPanel myTestContextPanel;
    private javax.swing.JTree myTestTree;
    // End of variables declaration//GEN-END:variables

    public void setContextController(AbstractContextController<?> ctxController) {
        myTestContextPanel.removeAll();
        if (ctxController != null) {
            final JPanel view = ctxController.getView();
            myTestContextPanel.add(view, BorderLayout.CENTER);
        }
        validate();
    }

    private void expandTreeModel(TreeNode root) {
        myTestTree.expandPath(new TreePath(myTreeModel.getPathToRoot(root)));

        for (Enumeration<?> enumeration = root.children(); enumeration.hasMoreElements(); ) {
            expandTreeModel((TreeNode) enumeration.nextElement());
        }
    }

    public void setBattery(TestBatteryImpl theBatteryImpl) {
        this.myBattery = theBatteryImpl;
        myTreeModel = new MyTreeModel(myBattery);
        myTestTree.setModel(myTreeModel);
        expandTreeModel(myTreeModel.getBatteryRoot());
    }
}
