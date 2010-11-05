maps = $(wildcard src/maps/*.java)
randomChoose = $(wildcard src/randomChoose/*.java)
dataWithEvaluations = $(wildcard src/dataWithEvaluations/*.java)

sources = $(randomChoose) $(maps) $(dataWithEvaluations)
classes = $(patsubst %.java, %.class, $(sources))

all: ConnectedPlanar.jar TwoConnected.jar ThreeConnected.jar

ConnectedPlanar.jar: src/ConnectedPlanar/Main.class $(classes)
	jar cf $@ $^

TwoConnected.jar: src/TwoConnected/Main.class $(classes)
	jar cf $@ $^

ThreeConnected.jar: src/ThreeConnected/Main.class $(classes)
	jar cf $@ $^

%.class: %.java
	javac -cp src $<

.PHONY: clean
clean:
	rm -f $(classes) $(wildcard *.jar)