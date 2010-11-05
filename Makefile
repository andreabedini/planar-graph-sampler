maps = $(wildcard src/maps/*.java)
randomChoose = $(wildcard src/randomChoose/*.java)
dataWithEvaluations = $(wildcard src/dataWithEvaluations/*.java)

sources = $(randomChoose) $(maps) $(dataWithEvaluations)
classes = $(patsubst %.java, %.class, $(sources))

all: Connected.jar TwoConnected.jar ThreeConnected.jar

Connected.jar: Connected.class $(classes)
	jar cfe $@ Connected $< -C src .

TwoConnected.jar: TwoConnected.class $(classes)
	jar cfe $@ TwoConnected $< -C src .

ThreeConnected.jar: ThreeConnected.class $(classes)
	jar cfe $@ ThreeConnected $< -C src .

%.class: %.java
	javac -cp src $<

.PHONY: clean
clean:
	rm -f $(classes) $(wildcard *.jar)