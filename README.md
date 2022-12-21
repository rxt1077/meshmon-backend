# meshmon-backend

A simple API backend and MeshPacket capture utility for use with
[MeshMon](https://github.com/rxt1077/MeshMon).

Currently it only saves Telemetry, NodeInfo, and Position MeshPackets. 

## Usage

```console
$ java -jar target/meshmon-backend-0.1.0-standalone.jar --help
2022-12-21 08:53:32.780:INFO::main: Logging initialized @1651ms to org.eclipse.jetty.util.log.StdErrLog

Usage is meshmon-backend [options]

Options:
  -r, --record                                record packets from device
  -s, --serial PORT                           use serial PORT for recording (autodetects if not specified)
  -p, --port PORTNUM  5000                    TCP port for HTTP connections
  -t, --static DIR    ./static                static files directory
  -u, --url URL       jdbc:sqlite:packets.db  jdbc URL for database
  -h, --help                                  display this help message
```
