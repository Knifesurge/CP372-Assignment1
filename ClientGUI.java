import java.awt.Color;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author USER 1
 */
public class ClientGUI extends javax.swing.JFrame {

    private static Client client = null;
    
    /**
     * Creates new form ClientGUI
     */
    public ClientGUI() {
        initComponents();
        // Create client object to handle connections
        //client = new Client(clientTerminal);

        // Initial Command GET, block out some unused textfields
        wTextField.setBackground(Color.GRAY);
        wTextField.setEditable(false);
        wTextField.setText("");
        hTextField.setBackground(Color.GRAY);
        hTextField.setEditable(false);
        hTextField.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        IPLabel = new javax.swing.JLabel();
        portLabel = new javax.swing.JLabel();
        IPTextField = new javax.swing.JTextField();
        portTextField = new javax.swing.JTextField();
        connectButton = new javax.swing.JButton();
        errorMessageLabel = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        clientTerminal = new javax.swing.JTextArea();
        sendMessageButton = new javax.swing.JButton();
        commandSelection = new javax.swing.JComboBox<>();
        argumentDescriptorLabel = new javax.swing.JLabel();
        argOption1TextField = new javax.swing.JTextField();
        argOption1Label = new javax.swing.JLabel();
        argOption2Label = new javax.swing.JLabel();
        xTextField = new javax.swing.JTextField();
        yTextField = new javax.swing.JTextField();
        argOption3Label = new javax.swing.JLabel();
        referstoTextField = new javax.swing.JTextField();
        wTextField = new javax.swing.JTextField();
        hTextField = new javax.swing.JTextField();
        pinsButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bulletin Board");

        IPLabel.setLabelFor(IPTextField);
        IPLabel.setText("IP Address");

        portLabel.setLabelFor(portTextField);
        portLabel.setText("Port");

        connectButton.setText("Connect");
        connectButton.setToolTipText("Connect to a server.");
        connectButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                connectButtonActionPerformed(evt);
            }
        });

        errorMessageLabel.setEnabled(false);

        clientTerminal.setEditable(false);
        clientTerminal.setColumns(20);
        clientTerminal.setRows(5);
        jScrollPane1.setViewportView(clientTerminal);
        clientTerminal.getAccessibleContext().setAccessibleName("Client Terminal");

        sendMessageButton.setText("Send");
        sendMessageButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sendMessageButtonActionPerformed(evt);
            }
        });

        commandSelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "GET", "POST", "PIN", "UNPIN", "SHAKE", "CLEAR", "DISCONNECT" }));
        commandSelection.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                commandSelectionItemStateChanged(evt);
            }
        });

        argOption1TextField.setText("color");
        argOption1TextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                argOption1TextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                argOption1TextFieldFocusLost(evt);
            }
        });

        argOption1Label.setLabelFor(argOption1Label);
        argOption1Label.setText("Color");

        argOption2Label.setText("Contains");

        xTextField.setText("x");
        xTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                xTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                xTextFieldFocusLost(evt);
            }
        });

        yTextField.setText("y");
        yTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                yTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                yTextFieldFocusLost(evt);
            }
        });

        argOption3Label.setLabelFor(argOption3Label);
        argOption3Label.setText("Refers To");

        referstoTextField.setText("refers to");
        referstoTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                referstoTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                referstoTextFieldFocusLost(evt);
            }
        });

        wTextField.setText("w");
        wTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                wTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                wTextFieldFocusLost(evt);
            }
        });

        hTextField.setText("h");
        hTextField.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                hTextFieldFocusGained(evt);
            }
            public void focusLost(java.awt.event.FocusEvent evt) {
                hTextFieldFocusLost(evt);
            }
        });

        pinsButton.setText("Get All Pins");
        pinsButton.setActionCommand("GetAllPins");
        pinsButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pinsButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(96, 96, 96)
                        .addComponent(errorMessageLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(36, 36, 36)
                        .addComponent(IPLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(IPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(portLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(connectButton))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(29, 29, 29)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 465, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(commandSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(argOption1Label)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(argOption1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pinsButton))
                                    .addComponent(argumentDescriptorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 287, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(sendMessageButton))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(argOption2Label)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(xTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(yTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(wTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(4, 4, 4)
                                    .addComponent(hTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(argOption3Label)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(referstoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 328, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(IPLabel)
                    .addComponent(IPTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(portLabel)
                    .addComponent(portTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(connectButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(errorMessageLabel)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sendMessageButton)
                    .addComponent(commandSelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(argOption1TextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(argOption1Label)
                    .addComponent(pinsButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(argOption2Label)
                    .addComponent(xTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(yTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(wTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(argumentDescriptorLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(argOption3Label)
                    .addComponent(referstoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(17, 17, 17))
        );

        errorMessageLabel.getAccessibleContext().setAccessibleName("Error Message Label");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void connectButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_connectButtonActionPerformed
        // Get the IP and the Port from their labels
        String IPAddress = IPTextField.getText();
        int portNumber = Integer.parseInt(portTextField.getText());

        System.out.println("Attempting connection to " + IPAddress + ":" + portNumber);

        // Create a new Client to handle the connections
        if (client == null) {
            client = new Client(clientTerminal);
        }
        // Attempt a connection if not already established
        if (!client.isConnected()) {
            client.connect(IPAddress, portNumber);
            // Start the SwingWorker client to handle the client connection
            client.execute();
        } else {
            clientTerminal.append("SYSTEM: You can only be connected to one server at a time.\n");
        }
    }//GEN-LAST:event_connectButtonActionPerformed

    private void commandSelectionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_commandSelectionItemStateChanged
        // Check that a new item was selected
        if (evt.getStateChange() == java.awt.event.ItemEvent.SELECTED) {
            String item = (String) evt.getItem();
            //System.out.println("Selected Item: " + item);
            
            // Reset the GUI components required
            if (item.equals("GET")) {
                argOption1Label.setVisible(true);
                argOption1Label.setText("Color");
                argOption1TextField.setEditable(true);
                argOption1TextField.setBackground(Color.WHITE);
                argOption1TextField.setText("color");
                argOption2Label.setVisible(true);
                argOption2Label.setText("Contains");
                xTextField.setEditable(true);
                xTextField.setBackground(Color.WHITE);
                xTextField.setText("x");
                yTextField.setEditable(true);
                yTextField.setBackground(Color.WHITE);
                yTextField.setText("y");
                wTextField.setEditable(false);
                wTextField.setBackground(Color.GRAY);
                wTextField.setText("");
                hTextField.setEditable(false);
                hTextField.setBackground(Color.GRAY);
                hTextField.setText("");
                referstoTextField.setEditable(true);
                referstoTextField.setBackground(Color.WHITE);
                referstoTextField.setText("refers to");
                argOption3Label.setVisible(true);
                argOption3Label.setText("Refers To");
                pinsButton.setVisible(true);
            } else if (item.equals("POST")) {
                pinsButton.setVisible(false);
                argOption1TextField.setEditable(true);
                argOption1TextField.setBackground(Color.WHITE);
                argOption1TextField.setText("color");
                xTextField.setEditable(true);
                xTextField.setBackground(Color.WHITE);
                xTextField.setText("x");
                yTextField.setEditable(true);
                yTextField.setBackground(Color.WHITE);
                yTextField.setText("y");
                wTextField.setEditable(true);
                wTextField.setBackground(Color.WHITE);
                wTextField.setText("w");
                hTextField.setEditable(true);
                hTextField.setBackground(Color.WHITE);
                hTextField.setText("h");
                argOption2Label.setText("Coords");
                argOption3Label.setText("Message");
                referstoTextField.setEditable(true);
                referstoTextField.setBackground(Color.WHITE);
                referstoTextField.setText("message");
            } else if (item.equals("PIN") || item.equals("UNPIN")) {
                xTextField.setEditable(true);
                xTextField.setBackground(Color.WHITE);
                xTextField.setText("x");
                yTextField.setEditable(true);
                yTextField.setBackground(Color.WHITE);
                yTextField.setText("y");
                argOption1TextField.setEditable(false);
                argOption1TextField.setBackground(Color.GRAY);
                argOption1TextField.setText("");
                wTextField.setEditable(false);
                wTextField.setBackground(Color.GRAY);
                wTextField.setText("");
                hTextField.setEditable(false);
                hTextField.setBackground(Color.GRAY);
                hTextField.setText("");
                referstoTextField.setEditable(false);
                referstoTextField.setBackground(Color.GRAY);
                referstoTextField.setText("");
                pinsButton.setVisible(false);
            } else {
                // SHAKE, CLEAR, DISCONNECT
                argOption1TextField.setEditable(false);
                argOption1TextField.setBackground(Color.GRAY);
                argOption1TextField.setText("");
                xTextField.setEditable(false);
                xTextField.setBackground(Color.GRAY);
                xTextField.setText("");
                yTextField.setEditable(false);
                yTextField.setBackground(Color.GRAY);
                yTextField.setText("");
                wTextField.setEditable(false);
                wTextField.setBackground(Color.GRAY);
                wTextField.setText("");
                hTextField.setEditable(false);
                hTextField.setBackground(Color.GRAY);
                hTextField.setText("");
                referstoTextField.setEditable(false);
                referstoTextField.setBackground(Color.GRAY);
                referstoTextField.setText("");
                pinsButton.setVisible(false);
            }
        }
    }//GEN-LAST:event_commandSelectionItemStateChanged

    private void sendMessageButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sendMessageButtonActionPerformed
        if (evt.getActionCommand().equals("Send")) {
            if (client != null && client.isConnected()) {
                String command = (String) commandSelection.getSelectedItem();
                String[] message = new String[7];

                String color = argOption1TextField.getText().equals("color") ? "all" : argOption1TextField.getText();
                int x =
                        xTextField.getText().equals("x") || xTextField.getText().isBlank()
                                ? -1
                                : Integer.parseInt(xTextField.getText());
                int y = yTextField.getText().equals("y") || yTextField.getText().isBlank()
                        ? -1
                        : Integer.parseInt(yTextField.getText());
                int w = wTextField.getText().equals("w") || wTextField.getText().isBlank()
                        ? -1
                        : Integer.parseInt(wTextField.getText());
                int h = hTextField.getText().equals("h") || hTextField.getText().isBlank()
                        ? -1
                        : Integer.parseInt(hTextField.getText());
                String content = referstoTextField.getText().equals("refers to") ||
                        referstoTextField.getText().equals("message")
                        ?
                        ""
                        :
                        referstoTextField.getText();

                message[0] = command;

                // Any unused spaces in array will be null value
                if (command.equals("GET")) {
                    message[1] = "color=" + color;
                    if (x != -1 && y != -1)
                        message[2] = "contains=" + x + " " + y;
                    if (!content.isEmpty())
                        message[3] = "refersTo=" + content;
                } else if (command.equals("POST")) {
                    message[1] = String.valueOf(x);
                    message[2] = String.valueOf(y);
                    message[3] = String.valueOf(w);
                    message[4] = String.valueOf(h);
                    message[5] = color;
                    message[6] = content;
                } else if (command.equals("PIN") || command.equals("UNPIN")) {
                    message[1] = x + "," + y;
                }

                boolean argsRequired = command.equalsIgnoreCase("shake") ||
                        command.equalsIgnoreCase("clear") ||
                        command.equalsIgnoreCase("disconnect")
                        ?
                        false
                        :
                        true;

                client.sendMessage(message, argsRequired);

                if (command.equals("DISCONNECT")) {
                    client.cancel(false);
                    client = null;
                }
            } else {
                clientTerminal.append("SYSTEM: Please connect to a server before sending a message.\n");
            }
        }
    }//GEN-LAST:event_sendMessageButtonActionPerformed

    private void argOption1TextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_argOption1TextFieldFocusGained
        // Check to see if some of the placeholder text is still here
        String text = argOption1TextField.getText();
        if (text.equalsIgnoreCase("color")) {
            // Placeholder text present, clear the text for User-defined text
            argOption1TextField.setText("");
            argOption1TextField.setCaretPosition(0);
        }
    }//GEN-LAST:event_argOption1TextFieldFocusGained

    private void argOption1TextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_argOption1TextFieldFocusLost
        // Check to see if we can put the placeholder text back
        String text = argOption1TextField.getText();
        String placeholderText = "color";
        if (text.isEmpty()) {
            // No User-defined text present, good to reset
            argOption1TextField.setCaretPosition(0);
            argOption1TextField.setText(placeholderText);
        }
    }//GEN-LAST:event_argOption1TextFieldFocusLost

    private void xTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xTextFieldFocusGained
        // Check to see if some of the placeholder text is still here
        String text = xTextField.getText();
        if (text.equalsIgnoreCase("x")) {
            // Placeholder text present, clear the text for User-defined text
            xTextField.setText("");
            xTextField.setCaretPosition(0);
        }
    }//GEN-LAST:event_xTextFieldFocusGained

    private void xTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_xTextFieldFocusLost
        // Check to see if we can put the placeholder text back
        String text = xTextField.getText();
        String placeholderText = "x";
        if (text.isEmpty()) {
            // No User-defined text present, good to reset
            xTextField.setCaretPosition(0);
            xTextField.setText(placeholderText);
        }
    }//GEN-LAST:event_xTextFieldFocusLost

    private void yTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_yTextFieldFocusLost
        // Check to see if we can put the placeholder text back
        String text = yTextField.getText();
        String placeholderText = "y";
        if (text.isEmpty()) {
            // No User-defined text present, good to reset
            yTextField.setCaretPosition(0);
            yTextField.setText(placeholderText);
        }
    }//GEN-LAST:event_yTextFieldFocusLost

    private void yTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_yTextFieldFocusGained
        // Check to see if some of the placeholder text is still here
        String text = yTextField.getText();
        if (text.equalsIgnoreCase("y")) {
            // Placeholder text present, clear the text for User-defined text
            yTextField.setText("");
            yTextField.setCaretPosition(0);
        }
    }//GEN-LAST:event_yTextFieldFocusGained

    private void wTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_wTextFieldFocusGained
        // Check to see if some of the placeholder text is still here
        String text = wTextField.getText();
        if (text.equalsIgnoreCase("w")) {
            // Placeholder text present, clear the text for User-defined text
            wTextField.setText("");
            wTextField.setCaretPosition(0);
        }
    }//GEN-LAST:event_wTextFieldFocusGained

    private void wTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_wTextFieldFocusLost
        // Check to see if we can put the placeholder text back
        String text = wTextField.getText();
        String placeholderText = "w";
        if (text.isEmpty()) {
            // No User-defined text present, good to reset
            wTextField.setCaretPosition(0);
            wTextField.setText(placeholderText);
        }
    }//GEN-LAST:event_wTextFieldFocusLost

    private void hTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hTextFieldFocusGained
        // Check to see if some of the placeholder text is still here
        String text = hTextField.getText();
        if (text.equalsIgnoreCase("h")) {
            // Placeholder text present, clear the text for User-defined text
            hTextField.setText("");
            hTextField.setCaretPosition(0);
        }
    }//GEN-LAST:event_hTextFieldFocusGained

    private void hTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_hTextFieldFocusLost
        // Check to see if we can put the placeholder text back
        String text = hTextField.getText();
        String placeholderText = "h";
        if (text.isEmpty()) {
            // No User-defined text present, good to reset
            hTextField.setCaretPosition(0);
            hTextField.setText(placeholderText);
        }
    }//GEN-LAST:event_hTextFieldFocusLost

    private void referstoTextFieldFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_referstoTextFieldFocusGained
        // Check to see if some of the placeholder text is still here
        String text = referstoTextField.getText();
        if (text.equalsIgnoreCase("refers to") || text.equalsIgnoreCase("message")) {
            // Placeholder text present, clear the text for User-defined text
            referstoTextField.setText("");
            referstoTextField.setCaretPosition(0);
        }
    }//GEN-LAST:event_referstoTextFieldFocusGained

    private void referstoTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_referstoTextFieldFocusLost
        // Check to see if we can put the placeholder text back
        String text = referstoTextField.getText();
        String placeholderText = "refers to";
        if (text.isEmpty()) {
            // No User-defined text present, good to reset
            referstoTextField.setCaretPosition(0);
            referstoTextField.setText(placeholderText);
        }
    }//GEN-LAST:event_referstoTextFieldFocusLost

    private void pinsButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pinsButtonActionPerformed
        if (evt.getActionCommand().equals("GetAllPins")) {
            if (client.isConnected()) {
                String[] message = new String[2];
                message[0] = "GET";
                message[1] = "PINS";
                client.sendMessage(message, true);
            } else {
                clientTerminal.append("SYSTEM: Please connect to a server before sending a message.\n");
            }
        }
    }//GEN-LAST:event_pinsButtonActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ClientGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ClientGUI().setVisible(true);
            }
        });
        /* Create the Client object to handle connections */
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel IPLabel;
    private javax.swing.JTextField IPTextField;
    private javax.swing.JLabel argOption1Label;
    private javax.swing.JTextField argOption1TextField;
    private javax.swing.JLabel argOption2Label;
    private javax.swing.JLabel argOption3Label;
    private javax.swing.JLabel argumentDescriptorLabel;
    private javax.swing.JTextArea clientTerminal;
    private javax.swing.JComboBox<String> commandSelection;
    private javax.swing.JButton connectButton;
    private javax.swing.JLabel errorMessageLabel;
    private javax.swing.JTextField hTextField;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton pinsButton;
    private javax.swing.JLabel portLabel;
    private javax.swing.JTextField portTextField;
    private javax.swing.JTextField referstoTextField;
    private javax.swing.JButton sendMessageButton;
    private javax.swing.JTextField wTextField;
    private javax.swing.JTextField xTextField;
    private javax.swing.JTextField yTextField;
    // End of variables declaration//GEN-END:variables
}
