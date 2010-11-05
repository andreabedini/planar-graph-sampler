sources = $(wildcard maps/*.java) $(wildcard dataWithEvaluations/*.java) $(wildcard randomChoose/*.java)
classes = $(patsubst %.java,%.class,$(sources))

all: ConnectedPlanar.jar TwoConnected.jar ThreeConnected.jar

ConnectedPlanar.jar: ConnectedPlanar/Main.class $(classes)
	jar cvf $@ $^

TwoConnected.jar: TwoConnected/Main.class $(classes)
	jar cvf $@ $^

ThreeConnected.jar: ThreeConnected/Main.class $(classes)
	jar cvf $@ $^

%.class: %.java
	javac $<
