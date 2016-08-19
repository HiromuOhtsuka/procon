arg = STDIN.gets
args = arg.split
n = args[0].to_i
t = args[1].to_i

printf("%.6f", (n * (1.000000011 ** t)))
puts
