// ...existing code...
    private final TextField TCPField;
    private final TextField UDPField;
    private final TextButton createButton;
// ...existing code...

    public LobbyMenu(Skin skin) {
        // ...existing code...
        TCPField = new TextField("TCP Port", skin);
        UDPField = new TextField("UDP Port", skin);
        createButton = new TextButton("Create Lobby", skin);
        // ...existing code...
    }
// ...existing code...

    @Override
    public void show() {
        // ...existing code...

        table.add(titleLabel);
        table.row().pad(15);
        table.add(TCPField).width(140);
        table.add(UDPField).width(140);
        table.add(createButton);
        table.row().pad(15);
        // ...existing code...

        if (!App.getCurrentUser().equals(App.getCurrentLobby().getAdmin())) {
            TCPField.setVisible(false);
            UDPField.setVisible(false);
            createButton.setVisible(false);
        }

        // ...existing code...

        createButton.addListener(new ClickListener() {
            @Override
            public void clicked(InputEvent event, float x, float y) {
                String tcpPort = TCPField.getText();
                String udpPort = UDPField.getText();

                File projectRoot = new File("/home/hamed/University/StardewValley");
                ProcessBuilder pb = new ProcessBuilder(
                    "./gradlew",
                    ":lwjgl3:runHeadless",
                    "--args=" + tcpPort + " " + udpPort
                );
                pb.directory(projectRoot);
                pb.inheritIO();
                try {
                    pb.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        // ...existing code...

        TCPField.addListener(new ClickListener() {
            boolean cleared = false;
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    TCPField.setText("");
                    cleared = true;
                }
            }
        });

        UDPField.addListener(new ClickListener() {
            boolean cleared = false;
            @Override
            public void clicked(InputEvent event, float x, float y) {
                if (!cleared) {
                    UDPField.setText("");
                    cleared = true;
                }
            }
        });

        TCPField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && TCPField.getText().isEmpty()) {
                    TCPField.setText("TCP Port");
                }
            }
        });

        UDPField.addListener(new FocusListener() {
            @Override
            public void keyboardFocusChanged(FocusEvent event, Actor actor, boolean focused) {
                if (!focused && UDPField.getText().isEmpty()) {
                    UDPField.setText("UDP Port");
                }
            }
        });

        // ...existing code...
    }
// ...existing code...
