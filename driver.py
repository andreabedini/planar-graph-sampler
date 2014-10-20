#!/usr/bin/env python

import shlex
import subprocess
import shelve

size_min = 50
size_max = 200
target = 100
chunk_size = 1000

program = 'TwoConnected'
outfilename = program + '.out'

with shelve.open('status.shelve', writeback=True) as status, open(outfilename, 'a') as out:
    histogram = status.get('histogram', {})
    number_of_runs = status.get('number_runs', 0)
    total_generated = status.get('total_generated', 0)
    total_kept = status.get('total_kept', 0)

    cmdline = 'java -jar {}.jar {}'.format(program, chunk_size)
    
    target_reached = False
    while not target_reached:
        try:
            out = subprocess.check_output(shlex.split(cmdline))
            number_of_runs = number_of_runs + 1
        except subprocess.CalledProcessError:
            pass

        lines = out.splitlines()
        total_generated = total_generated + len(lines)

        for line in lines:
            line = line.decode()
            n, e, graph = line.split()
            n = int(n)
            if n < size_min or n > size_max:
                continue
            
            out.write(line + '\n')
            histogram[n] = histogram.get(n, 0) + 1
        
        total_kept = sum(histogram.values())

        target_reached = True
        for value in histogram.values():
            if value < target:
                target_reached = False
                break
        
        print("Total kept ", total_kept)
        print("Total generated", total_generated)
        print("Minimum value", min(histogram.values()))
        
    status['histogram'] = histogram
    status['number_runs'] = number_of_runs
    status['total_generated'] = total_generated
    status['total_kept'] = total_kept
