import express from "express";
import routes from "./usecase.js";

const { getNote, createNote, getNoteById, updateNoteById, deleteNoteById } =
  routes;

const app = express();

app.use(
  express.urlencoded({
    extended: true,
  })
);

app.use(express.json());

const port = 3000

app.listen(port, () => console.log(`APP: Listening on port ${port}.`));

app.get("/notes/", getNote);
app.get("/notes/:id", getNoteById);
app.put("/notes/:id", updateNoteById);
app.delete("/notes/:id", deleteNoteById);
app.post("/notes/", createNote);
